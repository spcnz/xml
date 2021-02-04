
package tim21.PortalVlasti.soap.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mail package. 
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

    private final static QName _Mail_QNAME = new QName("http://www.mail.com", "mail");
    private final static QName _Response_QNAME = new QName("http://www.mail.com", "Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link tim21.PortalPoverenika.soap.dto.MailRequest }
     * 
     */
    public tim21.PortalPoverenika.soap.dto.MailRequest createMailRequest() {
        return new tim21.PortalPoverenika.soap.dto.MailRequest();
    }

    /**
     * Create an instance of {@link tim21.PortalPoverenika.soap.dto.TResponse }
     * 
     */
    public tim21.PortalPoverenika.soap.dto.TResponse createTResponse() {
        return new tim21.PortalPoverenika.soap.dto.TResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link tim21.PortalPoverenika.soap.dto.MailRequest }{@code >}}
     * 
     */

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link tim21.PortalPoverenika.soap.dto.TResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.mail.com", name = "response")
    public JAXBElement<tim21.PortalPoverenika.soap.dto.TResponse> createResponse(tim21.PortalPoverenika.soap.dto.TResponse value) {
        return new JAXBElement<tim21.PortalPoverenika.soap.dto.TResponse>(_Response_QNAME, tim21.PortalPoverenika.soap.dto.TResponse.class, null, value);
    }

}
