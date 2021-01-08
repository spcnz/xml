
package tim21.PortalPoverenika.model.rescript;

import tim21.PortalPoverenika.model.shared.TOsoba;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{3}-\d{2}-\d{4}/\d{4}-\d{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Status_zahteva">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="odbijen"/>
 *               &lt;enumeration value="prihvacen"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Opis_resenja" type="{http://www.resenje.com}TOpis_resenja"/>
 *         &lt;element name="Obrazlozenje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Opis_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Postupak_poverenika" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Odgovor_na_zalbu" type="{http://www.resenje.com}TOdgovor_na_zalbu"/>
 *                   &lt;element name="Uputstvo_o_pravnom_sredstvu" type="{http://www.resenje.com}TUpustvo_o_pravnom_sredstvu"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Poverenik" type="{http://www.shared.com}TOsoba"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dopustena_zalba" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "datum",
    "statusZahteva",
    "opisResenja",
    "obrazlozenje",
    "poverenik"
})
@XmlRootElement(name = "Resenje", namespace = "http://www.resenje.com")
public class Resenje {

    @XmlElement(name = "ID", namespace = "http://www.resenje.com", required = true)
    protected String id;
    @XmlElement(name = "Datum", namespace = "http://www.resenje.com", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "Status_zahteva", namespace = "http://www.resenje.com", required = true)
    protected String statusZahteva;
    @XmlElement(name = "Opis_resenja", namespace = "http://www.resenje.com", required = true)
    protected TOpisResenja opisResenja;
    @XmlElement(name = "Obrazlozenje", namespace = "http://www.resenje.com", required = true)
    protected Resenje.Obrazlozenje obrazlozenje;
    @XmlElement(name = "Poverenik", namespace = "http://www.resenje.com", required = true)
    protected TOsoba poverenik;
    @XmlAttribute(name = "dopustena_zalba")
    @XmlSchemaType(name = "anySimpleType")
    protected String dopustenaZalba;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the statusZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusZahteva() {
        return statusZahteva;
    }

    /**
     * Sets the value of the statusZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusZahteva(String value) {
        this.statusZahteva = value;
    }

    /**
     * Gets the value of the opisResenja property.
     * 
     * @return
     *     possible object is
     *     {@link TOpisResenja }
     *     
     */
    public TOpisResenja getOpisResenja() {
        return opisResenja;
    }

    /**
     * Sets the value of the opisResenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOpisResenja }
     *     
     */
    public void setOpisResenja(TOpisResenja value) {
        this.opisResenja = value;
    }

    /**
     * Gets the value of the obrazlozenje property.
     * 
     * @return
     *     possible object is
     *     {@link Resenje.Obrazlozenje }
     *     
     */
    public Resenje.Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Resenje.Obrazlozenje }
     *     
     */
    public void setObrazlozenje(Resenje.Obrazlozenje value) {
        this.obrazlozenje = value;
    }

    /**
     * Gets the value of the poverenik property.
     * 
     * @return
     *     possible object is
     *     {@link TOsoba }
     *     
     */
    public TOsoba getPoverenik() {
        return poverenik;
    }

    /**
     * Sets the value of the poverenik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TOsoba }
     *     
     */
    public void setPoverenik(TOsoba value) {
        this.poverenik = value;
    }

    /**
     * Gets the value of the dopustenaZalba property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDopustenaZalba() {
        return dopustenaZalba;
    }

    /**
     * Sets the value of the dopustenaZalba property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDopustenaZalba(String value) {
        this.dopustenaZalba = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Opis_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Postupak_poverenika" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Odgovor_na_zalbu" type="{http://www.resenje.com}TOdgovor_na_zalbu"/>
     *         &lt;element name="Uputstvo_o_pravnom_sredstvu" type="{http://www.resenje.com}TUpustvo_o_pravnom_sredstvu"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "opisZalbe",
        "postupakPoverenika",
        "odgovorNaZalbu",
        "uputstvoOPravnomSredstvu"
    })
    public static class Obrazlozenje {

        @XmlElement(name = "Opis_zalbe", namespace = "http://www.resenje.com", required = true)
        protected String opisZalbe;
        @XmlElement(name = "Postupak_poverenika", namespace = "http://www.resenje.com", required = true)
        protected String postupakPoverenika;
        @XmlElement(name = "Odgovor_na_zalbu", namespace = "http://www.resenje.com", required = true)
        protected TOdgovorNaZalbu odgovorNaZalbu;
        @XmlElement(name = "Uputstvo_o_pravnom_sredstvu", namespace = "http://www.resenje.com", required = true)
        protected TUpustvoOPravnomSredstvu uputstvoOPravnomSredstvu;

        /**
         * Gets the value of the opisZalbe property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpisZalbe() {
            return opisZalbe;
        }

        /**
         * Sets the value of the opisZalbe property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpisZalbe(String value) {
            this.opisZalbe = value;
        }

        /**
         * Gets the value of the postupakPoverenika property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPostupakPoverenika() {
            return postupakPoverenika;
        }

        /**
         * Sets the value of the postupakPoverenika property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPostupakPoverenika(String value) {
            this.postupakPoverenika = value;
        }

        /**
         * Gets the value of the odgovorNaZalbu property.
         * 
         * @return
         *     possible object is
         *     {@link TOdgovorNaZalbu }
         *     
         */
        public TOdgovorNaZalbu getOdgovorNaZalbu() {
            return odgovorNaZalbu;
        }

        /**
         * Sets the value of the odgovorNaZalbu property.
         * 
         * @param value
         *     allowed object is
         *     {@link TOdgovorNaZalbu }
         *     
         */
        public void setOdgovorNaZalbu(TOdgovorNaZalbu value) {
            this.odgovorNaZalbu = value;
        }

        /**
         * Gets the value of the uputstvoOPravnomSredstvu property.
         * 
         * @return
         *     possible object is
         *     {@link TUpustvoOPravnomSredstvu }
         *     
         */
        public TUpustvoOPravnomSredstvu getUputstvoOPravnomSredstvu() {
            return uputstvoOPravnomSredstvu;
        }

        /**
         * Sets the value of the uputstvoOPravnomSredstvu property.
         * 
         * @param value
         *     allowed object is
         *     {@link TUpustvoOPravnomSredstvu }
         *     
         */
        public void setUputstvoOPravnomSredstvu(TUpustvoOPravnomSredstvu value) {
            this.uputstvoOPravnomSredstvu = value;
        }

    }

}
