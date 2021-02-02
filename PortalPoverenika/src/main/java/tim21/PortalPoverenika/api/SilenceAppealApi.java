package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.model.lists.SilenceAppealList;
import tim21.PortalPoverenika.service.SilenceAppealService;

import javax.xml.bind.JAXBException;

@RestController
@RequestMapping(value = "/api/silenceappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class SilenceAppealApi {

    @Autowired
    SilenceAppealService appealService;

    //@PreAuthorize("hasRole('ROLE_CITIZEN')")
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaCutanjeRoot appeal)  {
        if (appealService.create(appeal)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<SilenceAppealList> getAllAppeals() {
        SilenceAppealList appeals = new SilenceAppealList();
        try {
            appeals = appealService.getAll();

            return new ResponseEntity(appeals, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getAppeal(@PathVariable String ID) {
        ZalbaCutanjeRoot appeal = appealService.getOne(ID);
        if(appeal != null)
            return new ResponseEntity(appeal, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}