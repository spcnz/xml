
package tim21.PortalPoverenika.model.decisionAppeal;

import tim21.PortalPoverenika.model.shared.*;
import tim21.PortalPoverenika.model.decisionAppeal.TPodnosilac;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


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
 *         &lt;element name="Naslov">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Primaoc" type="{http://www.zalbanaodluku.com}TPrimaoc"/>
 *         &lt;element name="Podnaslov">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="150"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element name="Pravno_lice" type="{http://www.shared.com}TPravno_lice"/>
 *           &lt;element name="Fizicko_lice" type="{http://www.shared.com}TFizicko_lice"/>
 *         &lt;/choice>
 *         &lt;element name="Tekst_zalbe" type="{http://www.zalbanaodluku.com}TText_zalbe"/>
 *         &lt;element name="Grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Podnosilac" type="{http://www.zalbanaodluku.com}TPodnosilac"/>
 *         &lt;element name="Napomena">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Tacka" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
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
@XmlRootElement(name = "Zalba", namespace = "http://www.zalbanaodluku.com")
public class Zalba {

    @XmlElement(name = "Naslov", namespace = "http://www.zalbanaodluku.com", required = true)
    protected String naslov;
    @XmlElement(name = "Primaoc", namespace = "http://www.zalbanaodluku.com", required = true)
    protected TPrimaoc primaoc;
    @XmlElement(name = "Podnaslov", namespace = "http://www.zalbanaodluku.com", required = true)
    protected String podnaslov;
    @XmlElement(name = "Pravno_lice", namespace = "http://www.zalbanaodluku.com")
    protected TPravnoLice pravnoLice;
    @XmlElement(name = "Fizicko_lice", namespace = "http://www.zalbanaodluku.com")
    protected TFizickoLice fizickoLice;
    @XmlElement(name = "Tekst_zalbe", namespace = "http://www.zalbanaodluku.com", required = true)
    protected TTextZalbe tekstZalbe;
    @XmlElement(name = "Grad", namespace = "http://www.zalbanaodluku.com", required = true)
    protected String grad;
    @XmlElement(name = "Datum", namespace = "http://www.zalbanaodluku.com", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(name = "Podnosilac", namespace = "http://www.zalbanaodluku.com", required = true)
    protected tim21.PortalPoverenika.model.decisionAppeal.TPodnosilac podnosilac;
    @XmlElement(name = "Napomena", namespace = "http://www.zalbanaodluku.com", required = true)
    protected Zalba.Napomena napomena;
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
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
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
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link tim21.PortalPoverenika.model.decisionAppeal.TPodnosilac }
     *     
     */
    public tim21.PortalPoverenika.model.decisionAppeal.TPodnosilac getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link tim21.PortalPoverenika.model.decisionAppeal.TPodnosilac }
     *     
     */
    public void setPodnosilac(TPodnosilac value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the napomena property.
     * 
     * @return
     *     possible object is
     *     {@link Zalba.Napomena }
     *     
     */
    public Zalba.Napomena getNapomena() {
        return napomena;
    }

    /**
     * Sets the value of the napomena property.
     * 
     * @param value
     *     allowed object is
     *     {@link Zalba.Napomena }
     *     
     */
    public void setNapomena(Zalba.Napomena value) {
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Tacka" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "tacka"
    })
    public static class Napomena {

        @XmlElement(name = "Tacka", namespace = "http://www.zalbanaodluku.com", required = true)
        protected List<Zalba.Napomena.Tacka> tacka;

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
         * {@link Zalba.Napomena.Tacka }
         * 
         * 
         */
        public List<Zalba.Napomena.Tacka> getTacka() {
            if (tacka == null) {
                tacka = new ArrayList<Zalba.Napomena.Tacka>();
            }
            return this.tacka;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="broj" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Tacka {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "broj", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger broj;

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
             * Gets the value of the broj property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getBroj() {
                return broj;
            }

            /**
             * Sets the value of the broj property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setBroj(BigInteger value) {
                this.broj = value;
            }

        }

    }

}
