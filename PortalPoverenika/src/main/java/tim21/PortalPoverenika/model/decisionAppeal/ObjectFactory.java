
package tim21.PortalPoverenika.model.decisionAppeal;

import tim21.PortalPoverenika.model.shared.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim21.PortalPoverenika.model package. 
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

    private final static QName _TTextZalbeDatumPodnosenjaZahteva_QNAME = new QName("", "Datum_podnosenja_zahteva");
    private final static QName _TTextZalbeOsnovaZalbe_QNAME = new QName("", "Osnova_zalbe");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalPoverenika.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Zalba }
     * 
     */
    public Zalba createZalba() {
        return new Zalba();
    }

    /**
     * Create an instance of {@link Zalba.Napomena }
     * 
     */
    public Zalba.Napomena createZalbaNapomena() {
        return new Zalba.Napomena();
    }

    /**
     * Create an instance of {@link TPrimaoc }
     * 
     */
    public TPrimaoc createTPrimaoc() {
        return new TPrimaoc();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link TTextZalbe }
     * 
     */
    public TTextZalbe createTTextZalbe() {
        return new TTextZalbe();
    }

    /**
     * Create an instance of {@link TPodnosilac }
     * 
     */
    public TPodnosilac createTPodnosilac() {
        return new TPodnosilac();
    }

    /**
     * Create an instance of {@link Tacka }
     * 
     */
    public Tacka createTacka() {
        return new Tacka();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link TdatumVreme }
     * 
     */
    public TdatumVreme createTdatumVreme() {
        return new TdatumVreme();
    }

    /**
     * Create an instance of {@link TtrazilacInformacije }
     * 
     */
    public TtrazilacInformacije createTtrazilacInformacije() {
        return new TtrazilacInformacije();
    }

    /**
     * Create an instance of {@link Zalba.Napomena.Tacka }
     * 
     */
    public Zalba.Napomena.Tacka createZalbaNapomenaTacka() {
        return new Zalba.Napomena.Tacka();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Datum_podnosenja_zahteva", scope = TTextZalbe.class)
    public JAXBElement<XMLGregorianCalendar> createTTextZalbeDatumPodnosenjaZahteva(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TTextZalbeDatumPodnosenjaZahteva_QNAME, XMLGregorianCalendar.class, TTextZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Osnova_zalbe", scope = TTextZalbe.class)
    public JAXBElement<String> createTTextZalbeOsnovaZalbe(String value) {
        return new JAXBElement<String>(_TTextZalbeOsnovaZalbe_QNAME, String.class, TTextZalbe.class, value);
    }

}
