package tim21.PortalVlasti.api;

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
import org.xmldb.api.base.XMLDBException;
//import tim21.PortalVlasti.dto.rescriptFilter.RescriptFilter;
import tim21.PortalVlasti.dto.rescriptFilter.RescriptFilter;
import tim21.PortalVlasti.model.lists.RescriptList;
import tim21.PortalVlasti.soap.dto.rescript.ResenjeRoot;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.MetaDataService;
import tim21.PortalVlasti.service.RescriptService;
import tim21.PortalVlasti.soap.client.MailClient;
import tim21.PortalVlasti.soap.dto.MailRequest;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalVlasti.util.constants.RDFConstants.RESCRIPT_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/rescript", produces = MediaType.APPLICATION_XML_VALUE)
public class RescriptApi {

    @Autowired
    RescriptService rescriptService;

    @Autowired
    private Environment env;

    @Autowired
    MetaDataService metaDataService;


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


    @RequestMapping(value = "/search/{KW}", method = RequestMethod.GET)
    public ResponseEntity<RescriptList> searchRescripts(@PathVariable String KW) {
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

}