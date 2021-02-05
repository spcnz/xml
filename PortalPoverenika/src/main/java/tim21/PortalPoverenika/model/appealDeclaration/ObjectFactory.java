
package tim21.PortalPoverenika.model.appealDeclaration;

import tim21.PortalPoverenika.model.decisionAppeal.TTextZalbe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.izjasnjavanjezalba package. 
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

    private final static QName _IzjasnjavanjeZalba_QNAME = new QName("http://www.izjasnjavanjezalba.com", "IzjasnjavanjeZalba");


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.izjasnjavanjezalba
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IzjasnjavanjeZalba }
     * 
     */
    public IzjasnjavanjeZalba createIzjasnjavanjeZalba() {
        return new IzjasnjavanjeZalba();
    }

    /**
     * Create an instance of {@link TIzjasnjavanjeZalbaDok }
     * 
     */
    public TIzjasnjavanjeZalbaDok createTIzjasnjavanjeZalbaDok() {
        return new TIzjasnjavanjeZalbaDok();
    }

    @XmlElementDecl(namespace = "", name = "IzjasnjavanjeZalba", scope = IzjasnjavanjeZalba.class)
    public JAXBElement<IzjasnjavanjeZalba> createIzjasnjavanjeZalba(IzjasnjavanjeZalba value) {
        return new JAXBElement<IzjasnjavanjeZalba>(_IzjasnjavanjeZalba_QNAME, IzjasnjavanjeZalba.class, IzjasnjavanjeZalba.class, value);
    }
}
