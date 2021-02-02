
package tim21.PortalPoverenika.model.rescript;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import tim21.PortalPoverenika.model.shared.TOsoba;



/**
 * <p>Java class for TResenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TResenje"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;pattern value="\d{3}-\d{2}-\d{4}/\d{4}-\d{2}"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Datum"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Status_zalbe"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.resenje.com&gt;TStatus_zalbe"&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Opis_resenja" type="{http://www.resenje.com}TOpis_resenja"/&gt;
 *         &lt;element name="Obrazlozenje"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Opis_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Postupak_poverenika" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Odgovor_na_zalbu" type="{http://www.resenje.com}TOdgovor_na_zalbu"/&gt;
 *                   &lt;element name="Uputstvo_o_pravnom_sredstvu" type="{http://www.resenje.com}TUpustvo_o_pravnom_sredstvu"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Poverenik" type="{http://www.shared.com}TOsoba"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TResenje", propOrder = {
    "id",
    "datum",
    "statusZalbe",
    "opisResenja",
    "obrazlozenje",
    "poverenik"
})
public class TResenje {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Datum", required = true)
    protected Datum datum;
    @XmlElement(name = "Status_zalbe", required = true)
    protected StatusZalbe statusZalbe;
    @XmlElement(name = "Opis_resenja", required = true)
    protected TOpisResenja opisResenja;
    @XmlElement(name = "Obrazlozenje", required = true)
    protected Obrazlozenje obrazlozenje;
    @XmlElement(name = "Poverenik", required = true)
    protected TOsoba poverenik;

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
     *     {@link Datum }
     *     
     */
    public Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datum }
     *     
     */
    public void setDatum(Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the statusZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link StatusZalbe }
     *     
     */
    public StatusZalbe getStatusZalbe() {
        return statusZalbe;
    }

    /**
     * Sets the value of the statusZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusZalbe }
     *     
     */
    public void setStatusZalbe(StatusZalbe value) {
        this.statusZalbe = value;
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
     *     {@link Obrazlozenje }
     *     
     */
    public Obrazlozenje getObrazlozenje() {
        return obrazlozenje;
    }

    /**
     * Sets the value of the obrazlozenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Obrazlozenje }
     *     
     */
    public void setObrazlozenje(Obrazlozenje value) {
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
     *       &lt;anyAttribute processContents='lax'/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Datum {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setValue(XMLGregorianCalendar value) {
            this.value = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Opis_zalbe" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Postupak_poverenika" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Odgovor_na_zalbu" type="{http://www.resenje.com}TOdgovor_na_zalbu"/&gt;
     *         &lt;element name="Uputstvo_o_pravnom_sredstvu" type="{http://www.resenje.com}TUpustvo_o_pravnom_sredstvu"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
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

        @XmlElement(name = "Opis_zalbe", required = true)
        protected String opisZalbe;
        @XmlElement(name = "Postupak_poverenika", required = true)
        protected String postupakPoverenika;
        @XmlElement(name = "Odgovor_na_zalbu", required = true)
        protected TOdgovorNaZalbu odgovorNaZalbu;
        @XmlElement(name = "Uputstvo_o_pravnom_sredstvu", required = true)
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.resenje.com&gt;TStatus_zalbe"&gt;
     *       &lt;anyAttribute processContents='lax'/&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class StatusZalbe {

        @XmlValue
        protected TStatusZalbe value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link TStatusZalbe }
         *     
         */
        public TStatusZalbe getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link TStatusZalbe }
         *     
         */
        public void setValue(TStatusZalbe value) {
            this.value = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }

}
