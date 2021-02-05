package tim21.PortalVlasti.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.RequestService;
import tim21.PortalVlasti.soap.client.MailClient;
import tim21.PortalVlasti.soap.dto.MailRequest;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/requests", produces = MediaType.APPLICATION_XML_VALUE)
public class RequestApi {

    @Autowired
    RequestService requestService;

    @Autowired
    private Environment env;


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


}