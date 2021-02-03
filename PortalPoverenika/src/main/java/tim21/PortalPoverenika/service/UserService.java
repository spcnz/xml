package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.jaxb.JaxB;
import tim21.PortalPoverenika.model.user.User;
import tim21.PortalPoverenika.repository.UserRepository;
import tim21.PortalPoverenika.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    public boolean create(User user) {
        if (Validator.validate(user.getClass(), user)){
            return userRepository.create(user);
        }
        return false;
    }

    public User getOne(String ID) {
        XMLResource xmlResource = userRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        User user = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            user = (User) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return user;
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.getOne(email);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
        }
    }
}
