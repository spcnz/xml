package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.decisionAppeal.TZalba;
import tim21.PortalPoverenika.model.decisionAppeal.Zalba;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.service.DecisionAppealService;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/decisionappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class DecisionAppealApi {

    @Autowired
    DecisionAppealService appealService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaRoot appeal) throws IOException, SAXException {
        if (appealService.create(appeal)){

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }   

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DecisionAppealList> getAllAppeals() {
        DecisionAppealList appeals = new DecisionAppealList();
        try {
            appeals = appealService.getAll();

            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getAppeal(@PathVariable String ID) {
        ZalbaRoot appeal = appealService.getOne(ID);
        if(appeal != null)
            return new ResponseEntity(appeal, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}