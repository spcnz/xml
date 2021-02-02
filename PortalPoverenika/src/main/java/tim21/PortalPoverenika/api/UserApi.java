package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tim21.PortalPoverenika.model.user.User;
import tim21.PortalPoverenika.service.UserService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_XML_VALUE)
public class UserApi {

    public static final String VALID_EMAIL_ADDRESS_REGEX ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    @Autowired
    UserService userService;

    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User user)  {
        if (userService.create(user)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //Path variable with dot gets truncated
    @RequestMapping(value="/{email:.+}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getUser(@PathVariable String email) {
        User user = userService.getOne(email);
        if(user != null)
            return new ResponseEntity(user, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}