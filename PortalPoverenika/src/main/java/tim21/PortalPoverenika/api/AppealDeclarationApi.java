package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim21.PortalPoverenika.model.appealDeclaration.IzjasnjavanjeZalba;
import tim21.PortalPoverenika.service.AppealDeclarationService;

@RestController
@RequestMapping(value = "/api/declaration", produces = MediaType.APPLICATION_XML_VALUE)
public class AppealDeclarationApi {

    @Autowired
    AppealDeclarationService declarationService;


    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getByAppealID(@PathVariable String ID) {
        try {
            IzjasnjavanjeZalba declaration = declarationService.getByAppealID(ID);

            return new ResponseEntity(declaration, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}