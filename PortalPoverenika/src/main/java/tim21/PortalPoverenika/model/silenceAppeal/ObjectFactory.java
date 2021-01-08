
package tim21.PortalPoverenika.model.silenceAppeal;

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

    private final static QName _ZalbaCutanjeSadrzajDatum_QNAME = new QName("", "datum");
    private final static QName _ZalbaCutanjeSadrzajNazivOrgana_QNAME = new QName("", "naziv_organa");
    private final static QName _ZalbaCutanjeSadrzajPodaciOZahtevu_QNAME = new QName("", "podaci_o_zahtevu");
    private final static QName _ZalbaCutanjeSadrzajPodnosilacZalbe_QNAME = new QName("", "podnosilac_zalbe");
    private final static QName _ZalbaCutanjeSadrzajRazlozi_QNAME = new QName("", "razlozi");
    private final static QName _ZalbaCutanjeSadrzajPodnaslov_QNAME = new QName("", "podnaslov");
    private final static QName _ZalbaCutanjeSadrzajDatumVreme_QNAME = new QName("", "datum_vreme");
    private final static QName _ZalbaCutanjeSadrzajIstaknuto_QNAME = new QName("", "istaknuto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalPoverenika.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZalbaCutanje }
     * 
     */
    public ZalbaCutanje createZalbaCutanje() {
        return new ZalbaCutanje();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj }
     * 
     */
    public ZalbaCutanje.Sadrzaj createZalbaCutanjeSadrzaj() {
        return new ZalbaCutanje.Sadrzaj();
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
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
    }

    /**
     * Create an instance of {@link TdatumVreme }
     * 
     */
    public TdatumVreme createTdatumVreme() {
        return new TdatumVreme();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link TtrazilacInformacije }
     * 
     */
    public TtrazilacInformacije createTtrazilacInformacije() {
        return new TtrazilacInformacije();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Razlozi }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Razlozi createZalbaCutanjeSadrzajRazlozi() {
        return new ZalbaCutanje.Sadrzaj.Razlozi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<XMLGregorianCalendar> createZalbaCutanjeSadrzajDatum(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ZalbaCutanjeSadrzajDatum_QNAME, XMLGregorianCalendar.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "naziv_organa", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajNazivOrgana(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajNazivOrgana_QNAME, String.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podaci_o_zahtevu", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajPodaciOZahtevu(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajPodaciOZahtevu_QNAME, String.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnosilac_zalbe", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<Object> createZalbaCutanjeSadrzajPodnosilacZalbe(Object value) {
        return new JAXBElement<Object>(_ZalbaCutanjeSadrzajPodnosilacZalbe_QNAME, Object.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.Razlozi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "razlozi", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.Razlozi> createZalbaCutanjeSadrzajRazlozi(ZalbaCutanje.Sadrzaj.Razlozi value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.Razlozi>(_ZalbaCutanjeSadrzajRazlozi_QNAME, ZalbaCutanje.Sadrzaj.Razlozi.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnaslov", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajPodnaslov(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajPodnaslov_QNAME, String.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum_vreme", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TdatumVreme> createZalbaCutanjeSadrzajDatumVreme(TdatumVreme value) {
        return new JAXBElement<TdatumVreme>(_ZalbaCutanjeSadrzajDatumVreme_QNAME, TdatumVreme.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "istaknuto", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<String> createZalbaCutanjeSadrzajIstaknuto(String value) {
        return new JAXBElement<String>(_ZalbaCutanjeSadrzajIstaknuto_QNAME, String.class, ZalbaCutanje.Sadrzaj.class, value);
    }

}
