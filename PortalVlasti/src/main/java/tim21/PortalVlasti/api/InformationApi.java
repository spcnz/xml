package tim21.PortalVlasti.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.model.lists.InformationList;
import tim21.PortalVlasti.service.InformationService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/informations", produces = MediaType.APPLICATION_XML_VALUE)
public class InformationApi {

    @Autowired
    InformationService informationService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createInformation(@RequestBody Obavestenje information) throws IOException, SAXException {
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

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getinformation(@PathVariable String ID) {
        Obavestenje information = informationService.getOne(ID);
        if(information != null)
            return new ResponseEntity(information, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}