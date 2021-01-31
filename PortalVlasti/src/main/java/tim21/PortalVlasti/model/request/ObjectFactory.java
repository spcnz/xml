
package tim21.PortalVlasti.model.request;

import tim21.PortalVlasti.model.shared.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tim21.PortalVlasti.model.request package. 
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

    private final static QName _ZahtevDokumentSadrzajTipZahteva_QNAME = new QName("http://www.zahtev.com", "tip_zahteva");
    private final static QName _ZahtevDokumentSadrzajTrazilacInformacije_QNAME = new QName("http://www.zahtev.com", "trazilac_informacije");
    private final static QName _ZahtevDokumentSadrzajOpisInformacije_QNAME = new QName("http://www.zahtev.com", "opis_informacije");
    private final static QName _ZahtevDokumentSadrzajNaciniDostave_QNAME = new QName("http://www.zahtev.com", "nacini_dostave");
    private final static QName _ZahtevDokumentSadrzajDatumVreme_QNAME = new QName("http://www.zahtev.com", "datum_vreme");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tim21.PortalVlasti.model.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZahtevDokument }
     * 
     */
    public ZahtevDokument createZahtevDokument() {
        return new ZahtevDokument();
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
     * Create an instance of {@link ZahtevDokument.Sadrzaj }
     * 
     */
    public ZahtevDokument.Sadrzaj createZahtevDokumentSadrzaj() {
        return new ZahtevDokument.Sadrzaj();
    }

    /**
     * Create an instance of {@link TNadlezniOrgan }
     * 
     */
    public TNadlezniOrgan createTNadlezniOrgan() {
        return new TNadlezniOrgan();
    }

    /**
     * Create an instance of {@link ZahtevDokument.Fusnote }
     * 
     */
    public ZahtevDokument.Fusnote createZahtevDokumentFusnote() {
        return new ZahtevDokument.Fusnote();
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
     * Create an instance of {@link ZahtevDokument.Sadrzaj.TipZahteva }
     * 
     */
    public ZahtevDokument.Sadrzaj.TipZahteva createZahtevDokumentSadrzajTipZahteva() {
        return new ZahtevDokument.Sadrzaj.TipZahteva();
    }

    /**
     * Create an instance of {@link ZahtevDokument.Sadrzaj.NaciniDostave }
     * 
     */
    public ZahtevDokument.Sadrzaj.NaciniDostave createZahtevDokumentSadrzajNaciniDostave() {
        return new ZahtevDokument.Sadrzaj.NaciniDostave();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ZahtevDokument.Sadrzaj.TipZahteva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "tip_zahteva", scope = ZahtevDokument.Sadrzaj.class)
    public JAXBElement<ZahtevDokument.Sadrzaj.TipZahteva> createZahtevDokumentSadrzajTipZahteva(ZahtevDokument.Sadrzaj.TipZahteva value) {
        return new JAXBElement<ZahtevDokument.Sadrzaj.TipZahteva>(_ZahtevDokumentSadrzajTipZahteva_QNAME, ZahtevDokument.Sadrzaj.TipZahteva.class, ZahtevDokument.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "trazilac_informacije", scope = ZahtevDokument.Sadrzaj.class)
    public JAXBElement<TtrazilacInformacije> createZahtevDokumentSadrzajTrazilacInformacije(TtrazilacInformacije value) {
        return new JAXBElement<TtrazilacInformacije>(_ZahtevDokumentSadrzajTrazilacInformacije_QNAME, TtrazilacInformacije.class, ZahtevDokument.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "opis_informacije", scope = ZahtevDokument.Sadrzaj.class)
    public JAXBElement<String> createZahtevDokumentSadrzajOpisInformacije(String value) {
        return new JAXBElement<String>(_ZahtevDokumentSadrzajOpisInformacije_QNAME, String.class, ZahtevDokument.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZahtevDokument.Sadrzaj.NaciniDostave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "nacini_dostave", scope = ZahtevDokument.Sadrzaj.class)
    public JAXBElement<ZahtevDokument.Sadrzaj.NaciniDostave> createZahtevDokumentSadrzajNaciniDostave(ZahtevDokument.Sadrzaj.NaciniDostave value) {
        return new JAXBElement<ZahtevDokument.Sadrzaj.NaciniDostave>(_ZahtevDokumentSadrzajNaciniDostave_QNAME, ZahtevDokument.Sadrzaj.NaciniDostave.class, ZahtevDokument.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.zahtev.com", name = "datum_vreme", scope = ZahtevDokument.Sadrzaj.class)
    public JAXBElement<TdatumVreme> createZahtevDokumentSadrzajDatumVreme(TdatumVreme value) {
        return new JAXBElement<TdatumVreme>(_ZahtevDokumentSadrzajDatumVreme_QNAME, TdatumVreme.class, ZahtevDokument.Sadrzaj.class, value);
    }

}
