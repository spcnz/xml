package tim21.PortalPoverenika.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.dto.decisionAppealFilter.DecisionAppealFilter;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.service.DecisionAppealService;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.util.mappers.DecisionAppealMapper;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static tim21.PortalPoverenika.util.constants.RDFConstants.DECISIONAPPEAL_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/decisionappeal", produces = MediaType.APPLICATION_XML_VALUE)
public class DecisionAppealApi {

    @Autowired
    DecisionAppealService appealService;

    @Autowired
    private MetaDataService metaDataService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createAppeal(@RequestBody ZalbaRoot appealReq) throws IOException, SAXException {

        ZalbaRoot appeal = DecisionAppealMapper.addStaticText(appealReq);
        appeal = appealService.create(appeal);
        if (appeal != null){
            return new ResponseEntity<>(appeal, HttpStatus.CREATED);
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

    @RequestMapping(value="/meta/search/", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@RequestBody DecisionAppealFilter filter) {
        List<ZalbaRoot> appeals = new ArrayList<ZalbaRoot>();
        List<String> res = new ArrayList<String>();
        try {
            res =  metaDataService.filter("Zalbe", filter);
            for(String key : res){
                String id = key.split("zalbe")[1].substring(1);    // format keya je http://zalbe/234213123
                appeals.add(appealService.getOne("Zalba" + id + ".xml"));
            }
            DecisionAppealList response = new DecisionAppealList(appeals);
            return new ResponseEntity(response , HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value= "/meta/rdf/{ID}", method=RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = DECISIONAPPEAL_RDF_RESOURCES + ID + ".rdf";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/xml; charset=utf-8");
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".rdf");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        }catch(Exception e){
            return new   ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value= "/meta/json/{ID}", method=RequestMethod.GET)
    public ResponseEntity<?> metaExportJSON(@PathVariable Long ID) throws IOException {

        String path = DECISIONAPPEAL_RDF_RESOURCES + ID + ".json";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".json");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        }catch(Exception e){
            return new   ResponseEntity(HttpStatus.BAD_REQUEST);
        }
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