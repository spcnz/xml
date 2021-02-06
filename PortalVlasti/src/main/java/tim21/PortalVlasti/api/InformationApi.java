package tim21.PortalVlasti.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.model.information.ObavestenjeRoot;
import tim21.PortalVlasti.model.lists.InformationList;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.InformationService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/information", produces = MediaType.APPLICATION_XML_VALUE)
public class InformationApi {

    @Autowired
    InformationService informationService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createInformation(@RequestBody ObavestenjeRoot information) throws IOException, SAXException {
        if (informationService.create(information)){

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<InformationList> getAllinformations() {

        try {
            InformationList informations = informationService.getAll();

            return new ResponseEntity(informations, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping(value="/all", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<InformationList> getAllInformationForUser() {
        InformationList res = new InformationList();
        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            res = informationService.getAllByUser(loggedIn.getEmail().getValue());

            return new ResponseEntity(res, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getInformation(@PathVariable String ID) {
        Obavestenje information = informationService.getOne(ID);
        if(information != null)
            return new ResponseEntity(information, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}