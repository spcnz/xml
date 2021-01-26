
package tim21.PortalPoverenika.model.silenceAppeal;

import tim21.PortalPoverenika.model.shared.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
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
     * Create an instance of {@link ZalbaCutanje.Sadrzaj }
     * 
     */
    public ZalbaCutanje.Sadrzaj createZalbaCutanjeSadrzaj() {
        return new ZalbaCutanje.Sadrzaj();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Razlozi }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Razlozi createZalbaCutanjeSadrzajRazlozi() {
        return new ZalbaCutanje.Sadrzaj.Razlozi();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Naziv }
     * 
     */
    public ZalbaCutanje.Naziv createZalbaCutanjeNaziv() {
        return new ZalbaCutanje.Naziv();
    }

    /**
     * Create an instance of {@link TPrimaoc }
     * 
     */
    public TPrimaoc createTPrimaoc() {
        return new TPrimaoc();
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
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Podnaslov }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Podnaslov createZalbaCutanjeSadrzajPodnaslov() {
        return new ZalbaCutanje.Sadrzaj.Podnaslov();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.NazivOrgana }
     * 
     */
    public ZalbaCutanje.Sadrzaj.NazivOrgana createZalbaCutanjeSadrzajNazivOrgana() {
        return new ZalbaCutanje.Sadrzaj.NazivOrgana();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Datum }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Datum createZalbaCutanjeSadrzajDatum() {
        return new ZalbaCutanje.Sadrzaj.Datum();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.PodaciOZahtevu }
     * 
     */
    public ZalbaCutanje.Sadrzaj.PodaciOZahtevu createZalbaCutanjeSadrzajPodaciOZahtevu() {
        return new ZalbaCutanje.Sadrzaj.PodaciOZahtevu();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Istaknuto }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Istaknuto createZalbaCutanjeSadrzajIstaknuto() {
        return new ZalbaCutanje.Sadrzaj.Istaknuto();
    }

    /**
     * Create an instance of {@link ZalbaCutanje.Sadrzaj.Razlozi.Opcija }
     * 
     */
    public ZalbaCutanje.Sadrzaj.Razlozi.Opcija createZalbaCutanjeSadrzajRazloziOpcija() {
        return new ZalbaCutanje.Sadrzaj.Razlozi.Opcija();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.Datum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datum", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.Datum> createZalbaCutanjeSadrzajDatum(ZalbaCutanje.Sadrzaj.Datum value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.Datum>(_ZalbaCutanjeSadrzajDatum_QNAME, ZalbaCutanje.Sadrzaj.Datum.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.NazivOrgana }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "naziv_organa", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.NazivOrgana> createZalbaCutanjeSadrzajNazivOrgana(ZalbaCutanje.Sadrzaj.NazivOrgana value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.NazivOrgana>(_ZalbaCutanjeSadrzajNazivOrgana_QNAME, ZalbaCutanje.Sadrzaj.NazivOrgana.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.PodaciOZahtevu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podaci_o_zahtevu", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.PodaciOZahtevu> createZalbaCutanjeSadrzajPodaciOZahtevu(ZalbaCutanje.Sadrzaj.PodaciOZahtevu value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.PodaciOZahtevu>(_ZalbaCutanjeSadrzajPodaciOZahtevu_QNAME, ZalbaCutanje.Sadrzaj.PodaciOZahtevu.class, ZalbaCutanje.Sadrzaj.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnosilac_zalbe", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<TtrazilacInformacije> createZalbaCutanjeSadrzajPodnosilacZalbe(TtrazilacInformacije value) {
        return new JAXBElement<TtrazilacInformacije>(_ZalbaCutanjeSadrzajPodnosilacZalbe_QNAME, TtrazilacInformacije.class, ZalbaCutanje.Sadrzaj.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.Podnaslov }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "podnaslov", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.Podnaslov> createZalbaCutanjeSadrzajPodnaslov(ZalbaCutanje.Sadrzaj.Podnaslov value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.Podnaslov>(_ZalbaCutanjeSadrzajPodnaslov_QNAME, ZalbaCutanje.Sadrzaj.Podnaslov.class, ZalbaCutanje.Sadrzaj.class, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.Istaknuto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "istaknuto", scope = ZalbaCutanje.Sadrzaj.class)
    public JAXBElement<ZalbaCutanje.Sadrzaj.Istaknuto> createZalbaCutanjeSadrzajIstaknuto(ZalbaCutanje.Sadrzaj.Istaknuto value) {
        return new JAXBElement<ZalbaCutanje.Sadrzaj.Istaknuto>(_ZalbaCutanjeSadrzajIstaknuto_QNAME, ZalbaCutanje.Sadrzaj.Istaknuto.class, ZalbaCutanje.Sadrzaj.class, value);
    }

}
