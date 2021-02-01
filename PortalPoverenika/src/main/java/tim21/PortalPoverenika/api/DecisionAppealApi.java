package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.dto.request.DecisionAppealFilterDTO;
import tim21.PortalPoverenika.model.decisionAppeal.Zalba;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.service.MetaDataService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/decisionappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class DecisionAppealApi {

    @Autowired
    DecisionAppealService appealService;

    @Autowired
    private MetaDataService metaDataService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody Zalba appeal) throws IOException, SAXException {
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
        Zalba appeal = appealService.getOne(ID);
        if(appeal != null)
            return new ResponseEntity(appeal, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value="/search/{KW}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<DecisionAppealList> searchAppeals(@PathVariable String KW) {
        DecisionAppealList appeals = new DecisionAppealList();
        try {
            appeals = appealService.search(KW);
            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/meta-search/", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody DecisionAppealFilterDTO filter) {
        DecisionAppealList appeals = new DecisionAppealList();
        List<String> res = new ArrayList<String>();
        try {
            res =  metaDataService.filter("Zalbe", filter);
            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}