
package tim21.PortalPoverenika.model.rescript;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.resenje package. 
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

    private final static QName _TUpustvoOPravnomSredstvuTaksa_QNAME = new QName("http://www.resenje.com", "Taksa");
    private final static QName _TOdgovorNaZalbuRazlozi_QNAME = new QName("http://www.resenje.com", "Razlozi");
    private final static QName _TOpisResenjaStavkeResenja_QNAME = new QName("http://www.resenje.com", "Stavke_resenja");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.resenje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TOdgovorNaZalbu }
     * 
     */
    public TOdgovorNaZalbu createTOdgovorNaZalbu() {
        return new TOdgovorNaZalbu();
    }

    /**
     * Create an instance of {@link TOpisResenja }
     * 
     */
    public TOpisResenja createTOpisResenja() {
        return new TOpisResenja();
    }

    /**
     * Create an instance of {@link TResenje }
     * 
     */
    public TResenje createTResenje() {
        return new TResenje();
    }

    /**
     * Create an instance of {@link ResenjeRoot }
     * 
     */
    public ResenjeRoot createResenjeRoot() {
        return new ResenjeRoot();
    }

    /**
     * Create an instance of {@link TUpustvoOPravnomSredstvu }
     * 
     */
    public TUpustvoOPravnomSredstvu createTUpustvoOPravnomSredstvu() {
        return new TUpustvoOPravnomSredstvu();
    }


    /**
     * Create an instance of {@link TOdgovorNaZalbu.Razlozi }
     * 
     */
    public TOdgovorNaZalbu.Razlozi createTOdgovorNaZalbuRazlozi() {
        return new TOdgovorNaZalbu.Razlozi();
    }

    /**
     * Create an instance of {@link TOpisResenja.StavkeResenja }
     * 
     */
    public TOpisResenja.StavkeResenja createTOpisResenjaStavkeResenja() {
        return new TOpisResenja.StavkeResenja();
    }

    /**
     * Create an instance of {@link TResenje.Datum }
     * 
     */
    public TResenje.Datum createTResenjeDatum() {
        return new TResenje.Datum();
    }

    /**
     * Create an instance of {@link TResenje.StatusZalbe }
     * 
     */
    public TResenje.StatusZalbe createTResenjeStatusZalbe() {
        return new TResenje.StatusZalbe();
    }

    /**
     * Create an instance of {@link TResenje.Obrazlozenje }
     * 
     */
    public TResenje.Obrazlozenje createTResenjeObrazlozenje() {
        return new TResenje.Obrazlozenje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.resenje.com", name = "Taksa", scope = TUpustvoOPravnomSredstvu.class)
    public JAXBElement<BigDecimal> createTUpustvoOPravnomSredstvuTaksa(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_TUpustvoOPravnomSredstvuTaksa_QNAME, BigDecimal.class, TUpustvoOPravnomSredstvu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOdgovorNaZalbu.Razlozi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.resenje.com", name = "Razlozi", scope = TOdgovorNaZalbu.class)
    public JAXBElement<TOdgovorNaZalbu.Razlozi> createTOdgovorNaZalbuRazlozi(TOdgovorNaZalbu.Razlozi value) {
        return new JAXBElement<TOdgovorNaZalbu.Razlozi>(_TOdgovorNaZalbuRazlozi_QNAME, TOdgovorNaZalbu.Razlozi.class, TOdgovorNaZalbu.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOpisResenja.StavkeResenja }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.resenje.com", name = "Stavke_resenja", scope = TOpisResenja.class)
    public JAXBElement<TOpisResenja.StavkeResenja> createTOpisResenjaStavkeResenja(TOpisResenja.StavkeResenja value) {
        return new JAXBElement<TOpisResenja.StavkeResenja>(_TOpisResenjaStavkeResenja_QNAME, TOpisResenja.StavkeResenja.class, TOpisResenja.class, value);
    }

}
