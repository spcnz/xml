package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.Resenje;
import tim21.PortalPoverenika.service.RescriptService;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping(value = "/api/rescript", produces = MediaType.APPLICATION_XML_VALUE)
public class RescriptApi {

    @Autowired
    RescriptService rescriptService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createUser(@RequestBody Resenje rescript)  {
        if (rescriptService.create(rescript)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RescriptList> getUsers() {
        RescriptList rescripts = new RescriptList();
        try {
            rescripts = rescriptService.getAll();
            System.out.println(rescripts.getRescripts().size());
            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRescript(@PathVariable String ID) {
        Resenje rescript = rescriptService.getOne(ID);
        if(rescript != null)
            return new ResponseEntity(rescript, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}