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
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.dto.requestFilter.RequestFilter;
import tim21.PortalVlasti.dto.rescriptFilter.RescriptFilter;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.model.lists.RescriptList;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.MetaDataService;
import tim21.PortalVlasti.service.RequestService;
import tim21.PortalVlasti.soap.client.MailClient;
import tim21.PortalVlasti.soap.dto.MailRequest;
import tim21.PortalVlasti.soap.dto.rescript.ResenjeRoot;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static tim21.PortalVlasti.util.constants.RDFConstants.REQUEST_RDF_RESOURCES;
import static tim21.PortalVlasti.util.constants.RDFConstants.RESCRIPT_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/requests", produces = MediaType.APPLICATION_XML_VALUE)
public class RequestApi {

    @Autowired
    RequestService requestService;

    @Autowired
    private Environment env;

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    MailClient mailClient;

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createRequest(@RequestBody ZahtevRoot requestReq) throws IOException, SAXException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ZahtevRoot request = requestService.create(requestReq, user.getEmail().getValue());

        if (request != null) {

            return new ResponseEntity<>(request, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }   

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RequestList> getAllRequests() {

        try {
            RequestList requests = requestService.getAll();

            return new ResponseEntity(requests, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRequest(@PathVariable String ID) {
        ZahtevRoot request = requestService.getOne(ID);
        if(request != null)
            return new ResponseEntity(request, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/reject/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> rejectRequest(@PathVariable String ID) {
        ZahtevRoot request = requestService.rejectRequest(ID);
        if (request == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("tim21.PortalVlasti.soap.dto");

        mailClient.setDefaultUri(env.getProperty("portal_poverenika"));
        mailClient.setMarshaller(marshaller);
        mailClient.setUnmarshaller(marshaller);

        String email;
        try {
            email = request.getOtherAttributes().get(new QName("href")).split("/")[3];
        } catch (Exception e ) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        MailRequest mail = new MailRequest();
        mail.setSubject("ZAHTEV ODBIJEN");
        mail.setContent("Postovani,\nVas zahtev za pristup javnim informacijama je odbijen.\n\n" +
                "ID podnetog zahteva: " + ID + "\n\n" +
                "Datum odbijanja zahteva: " + formatDate());
        mail.setTo(email);

        boolean sent = mailClient.sendMail(mail);
        if (sent) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    public String formatDate() {
        String pattern = "dd.MM.yyyy.";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());

        return date;
    }

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping(value = "/all",method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RequestList> getAllRequestsByUser() {
        RequestList requests = new RequestList();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {
            requests = requestService.getAllByUser(user.getEmail().getValue());

            return new ResponseEntity(requests, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/search/{KW}", method = RequestMethod.GET)
    public ResponseEntity<RequestList> searchRescripts(@PathVariable String KW) {
        RequestList rescripts = new RequestList();
        try {
            rescripts = requestService.search(KW);
            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/search/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody RequestFilter filter) {
        List<ZahtevRoot> requests = new ArrayList<ZahtevRoot>();
        List<String> res = new ArrayList<String>();

        List<String> filterVals = Arrays.asList(filter.getInstitutionName(), filter.getInstitutionOffice(), filter.getRequestType(),
                                                filter.getDelivery(), filter.getSubmitter(), filter.getSubmitterName(), filter.getSubmitterLastname(), filter.getAppealDate());
        try {
            res = metaDataService.filter("Zahtevi", filterVals);
            for (String key : res) {
                String id = key.split("zahtevi")[1].substring(1);    // format keya je http://zalbe/234213123
                requests.add(requestService.getOne(id));
            }

            RequestList response = new RequestList(requests);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/rdf/{ID}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = REQUEST_RDF_RESOURCES + ID + ".rdf";
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

        String path = REQUEST_RDF_RESOURCES + ID + ".json";
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