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
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.user.User;
import tim21.PortalVlasti.service.RequestService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/requests", produces = MediaType.APPLICATION_XML_VALUE)
public class RequestApi {

    @Autowired
    RequestService requestService;

    @PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createRequest(@RequestBody ZahtevRoot requestReq) throws IOException, SAXException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ZahtevRoot request = requestService.create(requestReq, user.getEmail().getValue());

        if (request != null) {

            return new ResponseEntity<>(HttpStatus.CREATED);
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

}