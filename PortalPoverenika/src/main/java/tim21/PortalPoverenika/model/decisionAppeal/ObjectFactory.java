
package tim21.PortalPoverenika.model.decisionAppeal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zalbanaodluku package. 
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

    private final static QName _TTextZalbeDatumPodnosenjaZahteva_QNAME = new QName("http://www.zalbanaodluku.com", "Datum_podnosenja_zahteva");
    private final static QName _TTextZalbeOsnovaZalbe_QNAME = new QName("http://www.zalbanaodluku.com", "Osnova_zalbe");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zalbanaodluku
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TTextZalbe }
     * 
     */
    public TTextZalbe createTTextZalbe() {
        return new TTextZalbe();
    }

    /**
     * Create an instance of {@link TZalba }
     * 
     */
    public TZalba createTZalba() {
        return new TZalba();
    }

    /**
     * Create an instance of {@link TZalba.Napomena }
     * 
     */
    public TZalba.Napomena createTZalbaNapomena() {
        return new TZalba.Napomena();
    }

    /**
     * Create an instance of {@link ZalbaRoot }
     * 
     */
    public ZalbaRoot createZalbaRoot() {
        return new ZalbaRoot();
    }

    /**
     * Create an instance of {@link TTextZalbe.DatumPodnosenjaZahteva }
     * 
     */
    public TTextZalbe.DatumPodnosenjaZahteva createTTextZalbeDatumPodnosenjaZahteva() {
        return new TTextZalbe.DatumPodnosenjaZahteva();
    }

    /**
     * Create an instance of {@link TTextZalbe.OsnovaZalbe }
     * 
     */
    public TTextZalbe.OsnovaZalbe createTTextZalbeOsnovaZalbe() {
        return new TTextZalbe.OsnovaZalbe();
    }

    /**
     * Create an instance of {@link TZalba.Grad }
     * 
     */
    public TZalba.Grad createTZalbaGrad() {
        return new TZalba.Grad();
    }

    /**
     * Create an instance of {@link TZalba.Datum }
     * 
     */
    public TZalba.Datum createTZalbaDatum() {
        return new TZalba.Datum();
    }

    /**
     * Create an instance of {@link TZalba.Napomena.Tacka }
     * 
     */
    public TZalba.Napomena.Tacka createTZalbaNapomenaTacka() {
        return new TZalba.Napomena.Tacka();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTextZalbe.DatumPodnosenjaZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbanaodluku.com", name = "Datum_podnosenja_zahteva", scope = TTextZalbe.class)
    public JAXBElement<TTextZalbe.DatumPodnosenjaZahteva> createTTextZalbeDatumPodnosenjaZahteva(TTextZalbe.DatumPodnosenjaZahteva value) {
        return new JAXBElement<TTextZalbe.DatumPodnosenjaZahteva>(_TTextZalbeDatumPodnosenjaZahteva_QNAME, TTextZalbe.DatumPodnosenjaZahteva.class, TTextZalbe.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTextZalbe.OsnovaZalbe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbanaodluku.com", name = "Osnova_zalbe", scope = TTextZalbe.class)
    public JAXBElement<TTextZalbe.OsnovaZalbe> createTTextZalbeOsnovaZalbe(TTextZalbe.OsnovaZalbe value) {
        return new JAXBElement<TTextZalbe.OsnovaZalbe>(_TTextZalbeOsnovaZalbe_QNAME, TTextZalbe.OsnovaZalbe.class, TTextZalbe.class, value);
    }

}
