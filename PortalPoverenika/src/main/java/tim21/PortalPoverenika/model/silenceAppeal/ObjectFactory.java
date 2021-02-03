
package tim21.PortalPoverenika.model.silenceAppeal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import tim21.PortalPoverenika.model.shared.*;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zalbacutanje package. 
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

    private final static QName _TZalbaCutanjeSadrzajPodnaslov_QNAME = new QName("http://www.zalbacutanje.com", "podnaslov");
    private final static QName _TZalbaCutanjeSadrzajNazivOrgana_QNAME = new QName("http://www.zalbacutanje.com", "naziv_organa");
    private final static QName _TZalbaCutanjeSadrzajRazlog_QNAME = new QName("http://www.zalbacutanje.com", "razlog");
    private final static QName _TZalbaCutanjeSadrzajDatum_QNAME = new QName("http://www.zalbacutanje.com", "datum");
    private final static QName _TZalbaCutanjeSadrzajPodaciOZahtevu_QNAME = new QName("http://www.zalbacutanje.com", "podaci_o_zahtevu");
    private final static QName _TZalbaCutanjeSadrzajIstaknuto_QNAME = new QName("http://www.zalbacutanje.com", "istaknuto");
    private final static QName _TZalbaCutanjeSadrzajPodnosilacZalbe_QNAME = new QName("http://www.zalbacutanje.com", "podnosilac_zalbe");
    private final static QName _TZalbaCutanjeSadrzajDatumVreme_QNAME = new QName("http://www.zalbacutanje.com", "datum_vreme");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zalbacutanje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TZalbaCutanje }
     * 
     */
    public TZalbaCutanje createTZalbaCutanje() {
        return new TZalbaCutanje();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj }
     * 
     */
    public TZalbaCutanje.Sadrzaj createTZalbaCutanjeSadrzaj() {
        return new TZalbaCutanje.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZalbaCutanjeRoot }
     * 
     */
    public ZalbaCutanjeRoot createZalbaCutanjeRoot() {
        return new ZalbaCutanjeRoot();
    }


    /**
     * Create an instance of {@link TZalbaCutanje.Naziv }
     * 
     */
    public TZalbaCutanje.Naziv createTZalbaCutanjeNaziv() {
        return new TZalbaCutanje.Naziv();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj.Podnaslov }
     * 
     */
    public TZalbaCutanje.Sadrzaj.Podnaslov createTZalbaCutanjeSadrzajPodnaslov() {
        return new TZalbaCutanje.Sadrzaj.Podnaslov();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj.NazivOrgana }
     * 
     */
    public TZalbaCutanje.Sadrzaj.NazivOrgana createTZalbaCutanjeSadrzajNazivOrgana() {
        return new TZalbaCutanje.Sadrzaj.NazivOrgana();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj.Datum }
     * 
     */
    public TZalbaCutanje.Sadrzaj.Datum createTZalbaCutanjeSadrzajDatum() {
        return new TZalbaCutanje.Sadrzaj.Datum();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj.PodaciOZahtevu }
     * 
     */
    public TZalbaCutanje.Sadrzaj.PodaciOZahtevu createTZalbaCutanjeSadrzajPodaciOZahtevu() {
        return new TZalbaCutanje.Sadrzaj.PodaciOZahtevu();
    }

    /**
     * Create an instance of {@link TZalbaCutanje.Sadrzaj.Istaknuto }
     * 
     */
    public TZalbaCutanje.Sadrzaj.Istaknuto createTZalbaCutanjeSadrzajIstaknuto() {
        return new TZalbaCutanje.Sadrzaj.Istaknuto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalbaCutanje.Sadrzaj.Podnaslov }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "podnaslov", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TZalbaCutanje.Sadrzaj.Podnaslov> createTZalbaCutanjeSadrzajPodnaslov(TZalbaCutanje.Sadrzaj.Podnaslov value) {
        return new JAXBElement<TZalbaCutanje.Sadrzaj.Podnaslov>(_TZalbaCutanjeSadrzajPodnaslov_QNAME, TZalbaCutanje.Sadrzaj.Podnaslov.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalbaCutanje.Sadrzaj.NazivOrgana }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "naziv_organa", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TZalbaCutanje.Sadrzaj.NazivOrgana> createTZalbaCutanjeSadrzajNazivOrgana(TZalbaCutanje.Sadrzaj.NazivOrgana value) {
        return new JAXBElement<TZalbaCutanje.Sadrzaj.NazivOrgana>(_TZalbaCutanjeSadrzajNazivOrgana_QNAME, TZalbaCutanje.Sadrzaj.NazivOrgana.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "razlog", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<String> createTZalbaCutanjeSadrzajRazlog(String value) {
        return new JAXBElement<String>(_TZalbaCutanjeSadrzajRazlog_QNAME, String.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalbaCutanje.Sadrzaj.Datum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "datum", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TZalbaCutanje.Sadrzaj.Datum> createTZalbaCutanjeSadrzajDatum(TZalbaCutanje.Sadrzaj.Datum value) {
        return new JAXBElement<TZalbaCutanje.Sadrzaj.Datum>(_TZalbaCutanjeSadrzajDatum_QNAME, TZalbaCutanje.Sadrzaj.Datum.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalbaCutanje.Sadrzaj.PodaciOZahtevu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "podaci_o_zahtevu", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TZalbaCutanje.Sadrzaj.PodaciOZahtevu> createTZalbaCutanjeSadrzajPodaciOZahtevu(TZalbaCutanje.Sadrzaj.PodaciOZahtevu value) {
        return new JAXBElement<TZalbaCutanje.Sadrzaj.PodaciOZahtevu>(_TZalbaCutanjeSadrzajPodaciOZahtevu_QNAME, TZalbaCutanje.Sadrzaj.PodaciOZahtevu.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZalbaCutanje.Sadrzaj.Istaknuto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "istaknuto", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TZalbaCutanje.Sadrzaj.Istaknuto> createTZalbaCutanjeSadrzajIstaknuto(TZalbaCutanje.Sadrzaj.Istaknuto value) {
        return new JAXBElement<TZalbaCutanje.Sadrzaj.Istaknuto>(_TZalbaCutanjeSadrzajIstaknuto_QNAME, TZalbaCutanje.Sadrzaj.Istaknuto.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "podnosilac_zalbe", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TtrazilacInformacije> createTZalbaCutanjeSadrzajPodnosilacZalbe(TtrazilacInformacije value) {
        return new JAXBElement<TtrazilacInformacije>(_TZalbaCutanjeSadrzajPodnosilacZalbe_QNAME, TtrazilacInformacije.class, TZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zalbacutanje.com", name = "datum_vreme", scope = TZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TdatumVreme> createTZalbaCutanjeSadrzajDatumVreme(TdatumVreme value) {
        return new JAXBElement<TdatumVreme>(_TZalbaCutanjeSadrzajDatumVreme_QNAME, TdatumVreme.class, TZalbaCutanje.Sadrzaj.class, value);
    }

}
