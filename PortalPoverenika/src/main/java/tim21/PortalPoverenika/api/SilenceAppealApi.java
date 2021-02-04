package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.dto.silenceAppealFilter.SilenceAppealFilter;
import tim21.PortalPoverenika.model.lists.SilenceAppealList;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.service.SilenceAppealService;
import tim21.PortalPoverenika.util.mappers.DecisionAppealMapper;
import tim21.PortalPoverenika.util.mappers.SilenceAppealMapper;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalPoverenika.util.constants.RDFConstants.DECISIONSILENCE_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/silenceappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class SilenceAppealApi {

    @Autowired
    SilenceAppealService appealService;

    @Autowired
    MetaDataService metaDataService;

    //@PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaCutanjeRoot appealReq) {
        ZalbaCutanjeRoot appeal = SilenceAppealMapper.addStaticText(appealReq);
        appeal = appealService.create(appeal);
        if (appeal != null) {
            return new ResponseEntity<>(appeal, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<SilenceAppealList> getAllAppeals() {
        SilenceAppealList appeals = new SilenceAppealList();
        try {
            appeals = appealService.getAll();

            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getAppeal(@PathVariable String ID) {
        ZalbaCutanjeRoot appeal = appealService.getOne(ID);
        if (appeal != null)
            return new ResponseEntity(appeal, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/search/{KW}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> searchAppeals(@PathVariable String KW) {
        SilenceAppealList appeals = new SilenceAppealList();
        try {
            appeals = appealService.search(KW);
            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/search/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody SilenceAppealFilter filter) {
        List<ZalbaCutanjeRoot> appeals = new ArrayList<ZalbaCutanjeRoot>();
        List<String> res = new ArrayList<String>();
        List<String> filterVals = Arrays.asList(filter.getSubmitterStreet(), filter.getSubmitterCity(), filter.getSubmitterName(), filter.getSubmitterLastname(),
                filter.getRequestId(), filter.getRequestDate(), filter.getRecipientStreet(), filter.getRecipientCity(), filter.getRequestDetails(), filter.getAuthorityName(), filter.getAppealDate());
        try {
            res = metaDataService.filter("ZalbeCutanje", filterVals);
            System.out.println("KLJUC  RES OVO ONO " + res.size());
            for (String key : res) {
                System.out.println("KLJUC " + key);
                String id = key.split("zalbeCutanje")[1].substring(1);    // format keya je http://zalbe/234213123
                appeals.add(appealService.getOne(id + ".xml"));
            }
            SilenceAppealList response = new SilenceAppealList(appeals);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/rdf/{ID}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = DECISIONSILENCE_RDF_RESOURCES + ID + ".rdf";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/xml; charset=utf-8");
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".rdf");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/json/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> metaExportJSON(@PathVariable Long ID) throws IOException {

        String path = DECISIONSILENCE_RDF_RESOURCES + ID + ".json";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".json");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/{ID}/generate", method = RequestMethod.GET)
    public ResponseEntity<?> generate(@PathVariable String ID, @RequestParam("type") String fileType) {
        String path = null;
        if (fileType.equals("pdf")) {
            path = appealService.generatePdf(ID);
        } else if (fileType.equals("html")) {
            path = appealService.generateHtml(ID);
        }


        if (path == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + "." + fileType);
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}