package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.dto.decisionAppealFilter.DecisionAppealFilter;
import tim21.PortalPoverenika.dto.rescriptFilter.RescriptFilter;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.model.user.User;
import tim21.PortalPoverenika.service.RescriptService;
import tim21.PortalPoverenika.service.SilenceAppealService;
import tim21.PortalPoverenika.soap.client.AppealAnnouncementClient;
import tim21.PortalPoverenika.soap.client.MailClient;
import tim21.PortalPoverenika.soap.client.RescriptClient;
import tim21.PortalPoverenika.soap.dto.MailRequest;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalPoverenika.util.constants.RDFConstants.DECISIONAPPEAL_RDF_RESOURCES;
import static tim21.PortalPoverenika.util.constants.RDFConstants.RESCRIPT_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/rescript", produces = MediaType.APPLICATION_XML_VALUE)
public class RescriptApi {

    @Autowired
    RescriptService rescriptService;

    @Autowired
    private Environment env;

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    RescriptClient rescriptClient;

    @Autowired
    DecisionAppealService decisionAppealService;

    @Autowired
    SilenceAppealService silenceAppealService;


    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createRescript(@RequestBody ResenjeRoot rescript)  {


        try {
            String appealID = rescript.getOtherAttributes().get(new QName("href")).split("/")[3];
            boolean appealValid = rescriptService.checkAppealId(appealID);
            if (!appealValid) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        rescript = rescriptService.create(rescript);
        if (rescript == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Boolean sent = rescriptService.sendToOffical(rescript);
        Boolean sendEmail = rescriptService.sendEmail(rescript);

        if (sent && sendEmail) {
            return new ResponseEntity<>(rescript, HttpStatus.CREATED);
        }


        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RescriptList> getAllRescriptsByUser() {
        RescriptList rescripts = new RescriptList();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            rescripts = rescriptService.getAllByUser(user.getEmail().getValue());

            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RescriptList> getAllRescripts() {
        RescriptList rescripts = new RescriptList();
        try {
            rescripts = rescriptService.getAll();

            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRescript(@PathVariable String ID) {
        ResenjeRoot rescript = rescriptService.getOne(ID);
        if(rescript != null)
            return new ResponseEntity(rescript, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/search/{KW}", method = RequestMethod.GET)
    public ResponseEntity<RescriptList> searchAppeals(@PathVariable String KW) {
        RescriptList rescripts = new RescriptList();
        try {
            rescripts = rescriptService.search(KW);
            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/search/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody RescriptFilter filter) {
        List<ResenjeRoot> rescripts = new ArrayList<ResenjeRoot>();
        List<String> res = new ArrayList<String>();
        List<String> filterVals = Arrays.asList(filter.getRescriptForAppeal(), filter.getRescriptDate(),
                                filter.getAppealStatus(), filter.getCommisionerName(), filter.getCommisionerLastname(), filter.getSubmitter());
        try {
            res = metaDataService.filter("Resenja", filterVals);
            for (String key : res) {
                String id = key.split("resenja")[1].substring(1);    // format keya je http://zalbe/234213123
                rescripts.add(rescriptService.getOne(id));
            }

            RescriptList response = new RescriptList(rescripts);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/rdf/{ID}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = RESCRIPT_RDF_RESOURCES + ID + ".rdf";
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

        String path = RESCRIPT_RDF_RESOURCES + ID + ".json";
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
            path = rescriptService.generatePdf(ID);
        } else if (fileType.equals("html")) {
            path = rescriptService.generateHtml(ID);
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