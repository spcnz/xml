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
import tim21.PortalVlasti.model.lists.AppealAnnouncementList;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.AppealAnnouncementService;
import tim21.PortalVlasti.service.RequestService;
import tim21.PortalVlasti.soap.client.MailClient;
import tim21.PortalVlasti.soap.dto.MailRequest;
import tim21.PortalVlasti.soap.dto.appealDeclaration.IzjasnjavanjeZalba;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/appeal-announcement", produces = MediaType.APPLICATION_XML_VALUE)
public class AppealAnnouncementApi {

    @Autowired
    AppealAnnouncementService announcementService;

    @Autowired
    private Environment env;


    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<AppealAnnouncementList> getAllAnnouncements() {

        try {
            AppealAnnouncementList list = announcementService.getAll();

            return new ResponseEntity(list, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/declare",  method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> sendDeclaration(@RequestBody IzjasnjavanjeZalba declaration) {

        boolean sent = announcementService.sendDeclaration(declaration);

        if (sent) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}