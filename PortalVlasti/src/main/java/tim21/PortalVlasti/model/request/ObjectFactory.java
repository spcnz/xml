
package tim21.PortalVlasti.model.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import tim21.PortalVlasti.model.shared.*;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim21.PortalVlasti.model.information package. 
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
    private final static QName _TZahtevSadrzajTrazilacInformacije_QNAME = new QName("http://www.zahtev.com", "trazilac_informacije");
    private final static QName _TZahtevSadrzajOpisInformacije_QNAME = new QName("http://www.zahtev.com", "opis_informacije");
    private final static QName _TZahtevSadrzajNaciniDostave_QNAME = new QName("http://www.zahtev.com", "nacini_dostave");
    private final static QName _TZahtevSadrzajDatumVreme_QNAME = new QName("http://www.zahtev.com", "datum_vreme");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalVlasti.model.information
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link TtrazilacInformacije }
     * 
     */
    public TtrazilacInformacije createTtrazilacInformacije() {
        return new TtrazilacInformacije();
    }

    /**
     * Create an instance of {@link TdatumVreme }
     * 
     */
    public TdatumVreme createTdatumVreme() {
        return new TdatumVreme();
    }

    /**
     * Create an instance of {@link TPravnoLice }
     * 
     */
    public TPravnoLice createTPravnoLice() {
        return new TPravnoLice();
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
     * Create an instance of {@link Tacka }
     * 
     */
    public Tacka createTacka() {
        return new Tacka();
    }

    /**
     * Create an instance of {@link Adresa.Grad }
     * 
     */
    public Adresa.Grad createAdresaGrad() {
        return new Adresa.Grad();
    }

    /**
     * Create an instance of {@link Adresa.Ulica }
     * 
     */
    public Adresa.Ulica createAdresaUlica() {
        return new Adresa.Ulica();
    }

    /**
     * Create an instance of {@link Adresa.Broj }
     * 
     */
    public Adresa.Broj createAdresaBroj() {
        return new Adresa.Broj();
    }

    /**
     * Create an instance of {@link TPrimaoc }
     * 
     */
    public TPrimaoc createTPrimaoc() {
        return new TPrimaoc();
    }

    /**
     * Create an instance of {@link TFizickoLice }
     * 
     */
    public TFizickoLice createTFizickoLice() {
        return new TFizickoLice();
    }

    /**
     * Create an instance of {@link TOsoba.Ime }
     * 
     */
    public TOsoba.Ime createTOsobaIme() {
        return new TOsoba.Ime();
    }

    /**
     * Create an instance of {@link TOsoba.Prezime }
     * 
     */
    public TOsoba.Prezime createTOsobaPrezime() {
        return new TOsoba.Prezime();
    }

    /**
     * Create an instance of {@link TtrazilacInformacije.DrugiPodaciZaKontakt }
     * 
     */
    public TtrazilacInformacije.DrugiPodaciZaKontakt createTtrazilacInformacijeDrugiPodaciZaKontakt() {
        return new TtrazilacInformacije.DrugiPodaciZaKontakt();
    }

    /**
     * Create an instance of {@link TdatumVreme.Vreme }
     * 
     */
    public TdatumVreme.Vreme createTdatumVremeVreme() {
        return new TdatumVreme.Vreme();
    }

    /**
     * Create an instance of {@link TdatumVreme.Datum }
     * 
     */
    public TdatumVreme.Datum createTdatumVremeDatum() {
        return new TdatumVreme.Datum();
    }

    /**
     * Create an instance of {@link TPravnoLice.Naziv }
     * 
     */
    public TPravnoLice.Naziv createTPravnoLiceNaziv() {
        return new TPravnoLice.Naziv();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "trazilac_informacije", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TtrazilacInformacije> createTZahtevSadrzajTrazilacInformacije(TtrazilacInformacije value) {
        return new JAXBElement<TtrazilacInformacije>(_TZahtevSadrzajTrazilacInformacije_QNAME, TtrazilacInformacije.class, TZahtev.Sadrzaj.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TZahtev.Sadrzaj.NaciniDostave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "nacini_dostave", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TZahtev.Sadrzaj.NaciniDostave> createTZahtevSadrzajNaciniDostave(TZahtev.Sadrzaj.NaciniDostave value) {
        return new JAXBElement<TZahtev.Sadrzaj.NaciniDostave>(_TZahtevSadrzajNaciniDostave_QNAME, TZahtev.Sadrzaj.NaciniDostave.class, TZahtev.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "datum_vreme", scope = TZahtev.Sadrzaj.class)
    public JAXBElement<TdatumVreme> createTZahtevSadrzajDatumVreme(TdatumVreme value) {
        return new JAXBElement<TdatumVreme>(_TZahtevSadrzajDatumVreme_QNAME, TdatumVreme.class, TZahtev.Sadrzaj.class, value);
    }

}
