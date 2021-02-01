package tim21.PortalPoverenika.api;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.util.mappers.DecisionAppealMapper;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/decisionappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class DecisionAppealApi {

    @Autowired
    DecisionAppealService appealService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaRoot appealReq) throws IOException, SAXException {

        ZalbaRoot appeal = DecisionAppealMapper.addStaticText(appealReq);
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

//    @RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
//    public void getFile(
//            @PathVariable("id") String fileName,
//            HttpServletResponse response) {
//        try {
//            // get your file as InputStream
//            InputStream in = getClass()
//                    .getResourceAsStream("classpath:pdf/bookstore.pdf");
//            // copy it to response's OutputStream
//            org.apache.commons.io.IOUtils.copy(in, response.getOutputStream());
//            response.flushBuffer();
//        } catch (IOException ex) {
//
//            throw new RuntimeException("IOError writing file to output stream");
//        }
//
//
//        return new FileSystemResource(myService.getFileFor(fileName));
//    }
//
//
//    @RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
//    @ResponseBody
//    public FileSystemResource getFile(@PathVariable("file_name") String fileName) {
//        return new FileSystemResource();
//    }
}