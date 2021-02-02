package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import tim21.PortalPoverenika.service.RescriptService;
import tim21.PortalPoverenika.soap.client.MailClient;
import tim21.PortalPoverenika.soap.dto.MailRequest;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/api/rescript", produces = MediaType.APPLICATION_XML_VALUE)
public class RescriptApi {

    @Autowired
    RescriptService rescriptService;

    @Autowired
    private Environment env;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createRescript(@RequestBody ResenjeRoot rescript)  {
        if (rescriptService.create(rescript)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<RescriptList> getAllRescripts() {
        RescriptList rescripts = new RescriptList();
        try {
            rescripts = rescriptService.getAll();

            return new ResponseEntity(rescripts, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getRescript(@PathVariable String ID) {
        ResenjeRoot rescript = rescriptService.getOne(ID);
        if(rescript != null)
            return new ResponseEntity(rescript, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/{ID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> sendToApplicant(@PathVariable String ID, @RequestBody MailRequest request) {
//        ResenjeRoot rescript = rescriptService.getOne(ID);
//        if(rescript != null) {
//            ovde ce se generisati pdf
//            uzeti njegova putanja i pretvoriti u bajtove
//            za sad cemo ovkako
            Path pdfPath = Paths.get("C:/Users/bekim/Desktop/xml/PortalPoverenika/src/main/resources/pdf/bookstore.pdf");
            try {
                byte[] byteArr = Files.readAllBytes(pdfPath);
            } catch (IOException e) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("tim21.PortalPoverenika.soap.dto");

            MailClient mailClient = new MailClient();
            mailClient.setDefaultUri(env.getProperty("portal_vlasti"));
            mailClient.setMarshaller(marshaller);
            mailClient.setUnmarshaller(marshaller);

            boolean sent = mailClient.sendMail(request);
            if(sent){
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }


//        }
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}