
package tim21.PortalPoverenika.model.decisionAppeal;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import tim21.PortalPoverenika.model.shared.*;


/**
 * <p>Java class for TZalba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TZalba"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Naslov"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Primaoc" type="{http://www.shared.com}TPrimaoc"/&gt;
 *         &lt;element name="Podnaslov"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="150"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Pravno_lice" type="{http://www.shared.com}TPravno_lice"/&gt;
 *           &lt;element name="Fizicko_lice" type="{http://www.shared.com}TFizicko_lice"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Tekst_zalbe" type="{http://www.zalbanaodluku.com}TText_zalbe"/&gt;
 *         &lt;element name="Grad"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;anyAttribute processContents='lax'/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
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
 *         &lt;element name="Podnosilac" type="{http://www.shared.com}Ttrazilac_informacije"/&gt;
 *         &lt;element name="Napomena"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Tacka" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                           &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TZalba", propOrder = {
    "naslov",
    "primaoc",
    "podnaslov",
    "pravnoLice",
    "fizickoLice",
    "tekstZalbe",
    "grad",
    "datum",
    "podnosilac",
    "napomena"
})
public class TZalba {

    @XmlElement(name = "Naslov", required = true)
    protected String naslov;
    @XmlElement(name = "Primaoc", required = true)
    protected TPrimaoc primaoc;
    @XmlElement(name = "Podnaslov", required = true)
    protected String podnaslov;
    @XmlElement(name = "Pravno_lice")
    protected TPravnoLice pravnoLice;
    @XmlElement(name = "Fizicko_lice")
    protected TFizickoLice fizickoLice;
    @XmlElement(name = "Tekst_zalbe", required = true)
    protected TTextZalbe tekstZalbe;
    @XmlElement(name = "Grad", required = true)
    protected Grad grad;
    @XmlElement(name = "Datum", required = true)
    protected Datum datum;
    @XmlElement(name = "Podnosilac", required = true)
    protected TtrazilacInformacije podnosilac;
    @XmlElement(name = "Napomena", required = true)
    protected Napomena napomena;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the primaoc property.
     * 
     * @return
     *     possible object is
     *     {@link TPrimaoc }
     *     
     */
    public TPrimaoc getPrimaoc() {
        return primaoc;
    }

    /**
     * Sets the value of the primaoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPrimaoc }
     *     
     */
    public void setPrimaoc(TPrimaoc value) {
        this.primaoc = value;
    }

    /**
     * Gets the value of the podnaslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPodnaslov() {
        return podnaslov;
    }

    /**
     * Sets the value of the podnaslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPodnaslov(String value) {
        this.podnaslov = value;
    }

    /**
     * Gets the value of the pravnoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TPravnoLice }
     *     
     */
    public TPravnoLice getPravnoLice() {
        return pravnoLice;
    }

    /**
     * Sets the value of the pravnoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPravnoLice }
     *     
     */
    public void setPravnoLice(TPravnoLice value) {
        this.pravnoLice = value;
    }

    /**
     * Gets the value of the fizickoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TFizickoLice }
     *     
     */
    public TFizickoLice getFizickoLice() {
        return fizickoLice;
    }

    /**
     * Sets the value of the fizickoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFizickoLice }
     *     
     */
    public void setFizickoLice(TFizickoLice value) {
        this.fizickoLice = value;
    }

    /**
     * Gets the value of the tekstZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link TTextZalbe }
     *     
     */
    public TTextZalbe getTekstZalbe() {
        return tekstZalbe;
    }

    /**
     * Sets the value of the tekstZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTextZalbe }
     *     
     */
    public void setTekstZalbe(TTextZalbe value) {
        this.tekstZalbe = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link Grad }
     *     
     */
    public Grad getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Grad }
     *     
     */
    public void setGrad(Grad value) {
        this.grad = value;
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
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link TtrazilacInformacije }
     *     
     */
    public TtrazilacInformacije getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TtrazilacInformacije }
     *     
     */
    public void setPodnosilac(TtrazilacInformacije value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the napomena property.
     * 
     * @return
     *     possible object is
     *     {@link Napomena }
     *     
     */
    public Napomena getNapomena() {
        return napomena;
    }

    /**
     * Sets the value of the napomena property.
     * 
     * @param value
     *     allowed object is
     *     {@link Napomena }
     *     
     */
    public void setNapomena(Napomena value) {
        this.napomena = value;
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
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
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
    public static class Grad {

        @XmlValue
        protected String value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
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
     *         &lt;element name="Tacka" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *                 &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "tacka"
    })
    public static class Napomena {

        @XmlElement(name = "Tacka", namespace = "http://www.shared.com", required = true)
        protected List<Tacka> tacka;

        /**
         * Gets the value of the tacka property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tacka property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTacka().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tacka }
         * 
         * 
         */
        public List<Tacka> getTacka() {
            if (tacka == null) {
                tacka = new ArrayList<Tacka>();
            }
            return this.tacka;
        }

    }

}
