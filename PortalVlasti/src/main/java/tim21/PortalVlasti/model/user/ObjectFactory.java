
package tim21.PortalVlasti.model.user;

import tim21.PortalVlasti.model.user.User;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim21.PortalVlasti.model package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalVlasti.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link tim21.PortalVlasti.model.user.User }
     * 
     */
    public tim21.PortalVlasti.model.user.User createUser() {
        return new tim21.PortalVlasti.model.user.User();
    }

    /**
     * Create an instance of {@link tim21.PortalVlasti.model.user.User.Email }
     * 
     */
    public tim21.PortalVlasti.model.user.User.Email createUserEmail() {
        return new User.Email();
    }

}
