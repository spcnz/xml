
package tim21.PortalPoverenika.soap.dto.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import tim21.PortalPoverenika.model.shared.TdatumVreme;
import tim21.PortalPoverenika.model.shared.TtrazilacInformacije;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zahtev package. 
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

    private final static QName _TZahtevSadrzajTipZahteva_QNAME = new QName("http://www.zahtev.com", "tip_zahteva");
    private final static QName _TZahtevSadrzajNaciniDostave_QNAME = new QName("http://www.zahtev.com", "nacini_dostave");
    private final static QName _TZahtevSadrzajOpisInformacije_QNAME = new QName("http://www.zahtev.com", "opis_informacije");
    private final static QName _TZahtevSadrzajTrazilacInformacije_QNAME = new QName("http://www.zahtev.com", "trazilac_informacije");
    private final static QName _TZahtevSadrzajDatumVreme_QNAME = new QName("http://www.zahtev.com", "datum_vreme");


    private final static QName _Subjectddd_QNAME = new QName("http://www.zahtev.com", "value");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zahtev
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TNadlezniOrgan }
     * 
     */
    public TNadlezniOrgan createTNadlezniOrgan() {
        return new TNadlezniOrgan();
    }

    /**
     * Create an instance of {@link TZahtev }
     * 
     */
    public TZahtev createTZahtev() {
        return new TZahtev();
    }

    /**
     * Create an instance of {@link TZahtev.Sadrzaj }
     * 
     */
    public TZahtev.Sadrzaj createTZahtevSadrzaj() {
        return new TZahtev.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZahtevRoot }
     * 
     */
    public ZahtevRoot createZahtevRoot() {
        return new ZahtevRoot();
    }

    /**
     * Create an instance of {@link TnaciniDostave }
     * 
     */
    public TnaciniDostave createTnaciniDostave() {
        return new TnaciniDostave();
    }

    /**
     * Create an instance of {@link TNadlezniOrgan.Naziv }
     * 
     */
    public TNadlezniOrgan.Naziv createTNadlezniOrganNaziv() {
        return new TNadlezniOrgan.Naziv();
    }

    /**
     * Create an instance of {@link TNadlezniOrgan.Sediste }
     * 
     */
    public TNadlezniOrgan.Sediste createTNadlezniOrganSediste() {
        return new TNadlezniOrgan.Sediste();
    }

    /**
     * Create an instance of {@link TZahtev.Fusnote }
     * 
     */
    public TZahtev.Fusnote createTZahtevFusnote() {
        return new TZahtev.Fusnote();
    }

    /**
     * Create an instance of {@link TZahtev.Sadrzaj.TipZahteva }
     * 
     */
    public TZahtev.Sadrzaj.TipZahteva createTZahtevSadrzajTipZahteva() {
        return new TZahtev.Sadrzaj.TipZahteva();
    }

    /**
     * Create an instance of {@link TZahtev.Sadrzaj.NaciniDostave }
     * 
     */
    public TZahtev.Sadrzaj.NaciniDostave createTZahtevSadrzajNaciniDostave() {
        return new TZahtev.Sadrzaj.NaciniDostave();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZahtev.Sadrzaj.TipZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "tip_zahteva", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TZahtev.Sadrzaj.TipZahteva> createTZahtevSadrzajTipZahteva(TZahtev.Sadrzaj.TipZahteva value) {
        return new JAXBElement<TZahtev.Sadrzaj.TipZahteva>(_TZahtevSadrzajTipZahteva_QNAME, TZahtev.Sadrzaj.TipZahteva.class, TZahtev.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TZahtev.Sadrzaj.NaciniDostave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "nacini_dostave", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TZahtev.Sadrzaj.NaciniDostave> createTZahtevSadrzajNaciniDostave(TZahtev.Sadrzaj.NaciniDostave value) {
        return new JAXBElement<TZahtev.Sadrzaj.NaciniDostave>(_TZahtevSadrzajNaciniDostave_QNAME, TZahtev.Sadrzaj.NaciniDostave.class, TZahtev.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "opis_informacije", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<String> createTZahtevSadrzajOpisInformacije(String value) {
        return new JAXBElement<String>(_TZahtevSadrzajOpisInformacije_QNAME, String.class, TZahtev.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "trazilac_informacije", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TtrazilacInformacije> createTZahtevSadrzajTrazilacInformacije(TtrazilacInformacije value) {
        return new JAXBElement<TtrazilacInformacije>(_TZahtevSadrzajTrazilacInformacije_QNAME, TtrazilacInformacije.class, TZahtev.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "datum_vreme", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TdatumVreme> createTZahtevSadrzajDatumVreme(TdatumVreme value) {
        return new JAXBElement<TdatumVreme>(_TZahtevSadrzajDatumVreme_QNAME, TdatumVreme.class, TZahtev.Sadrzaj.class, value);
    }


    @XmlElementDecl(namespace = "", name = "value")
    public JAXBElement<String> createRequest(String value) {
        return new JAXBElement<String>(_Subjectddd_QNAME, String.class, null, value);
    }


}
