
package tim21.PortalVlasti.model.request;

import tim21.PortalVlasti.model.shared.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="nadlezni_organ" type="{http://www.zahtev.com}TNadlezni_organ"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sadrzaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tip_zahteva">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.zahtev.com>TTipovi_zahteva">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="nacini_dostave">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://www.zahtev.com}Tnacini_dostave">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="opis_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="trazilac_informacije" type="{http://www.shared.com}Ttrazilac_informacije"/>
 *                   &lt;element name="datum_vreme" type="{http://www.shared.com}Tdatum_vreme"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="fusnote">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="fusnota" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
    "nadlezniOrgan",
    "naslov",
    "sadrzaj",
    "fusnote"
})
@XmlRootElement(name = "zahtev_dokument", namespace = "http://www.zahtev.com")
public class ZahtevDokument {

    @XmlElement(name = "nadlezni_organ", namespace = "http://www.zahtev.com", required = true)
    protected TNadlezniOrgan nadlezniOrgan;
    @XmlElement(namespace = "http://www.zahtev.com", required = true)
    protected String naslov;
    @XmlElement(namespace = "http://www.zahtev.com", required = true)
    protected ZahtevDokument.Sadrzaj sadrzaj;
    @XmlElement(namespace = "http://www.zahtev.com", required = true)
    protected ZahtevDokument.Fusnote fusnote;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the nadlezniOrgan property.
     * 
     * @return
     *     possible object is
     *     {@link TNadlezniOrgan }
     *     
     */
    public TNadlezniOrgan getNadlezniOrgan() {
        return nadlezniOrgan;
    }

    /**
     * Sets the value of the nadlezniOrgan property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNadlezniOrgan }
     *     
     */
    public void setNadlezniOrgan(TNadlezniOrgan value) {
        this.nadlezniOrgan = value;
    }

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
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevDokument.Sadrzaj }
     *     
     */
    public ZahtevDokument.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevDokument.Sadrzaj }
     *     
     */
    public void setSadrzaj(ZahtevDokument.Sadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the fusnote property.
     * 
     * @return
     *     possible object is
     *     {@link ZahtevDokument.Fusnote }
     *     
     */
    public ZahtevDokument.Fusnote getFusnote() {
        return fusnote;
    }

    /**
     * Sets the value of the fusnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZahtevDokument.Fusnote }
     *     
     */
    public void setFusnote(ZahtevDokument.Fusnote value) {
        this.fusnote = value;
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
     *         &lt;element name="fusnota" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
        "fusnota"
    })
    public static class Fusnote {

        @XmlElement(namespace = "http://www.zahtev.com", required = true)
        protected List<String> fusnota;

        /**
         * Gets the value of the fusnota property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the fusnota property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFusnota().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFusnota() {
            if (fusnota == null) {
                fusnota = new ArrayList<String>();
            }
            return this.fusnota;
        }

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
     *         &lt;element name="tip_zahteva">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.zahtev.com>TTipovi_zahteva">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="nacini_dostave">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://www.zahtev.com}Tnacini_dostave">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="opis_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="trazilac_informacije" type="{http://www.shared.com}Ttrazilac_informacije"/>
     *         &lt;element name="datum_vreme" type="{http://www.shared.com}Tdatum_vreme"/>
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
        "content"
    })
    public static class Sadrzaj {

        @XmlElementRefs({
            @XmlElementRef(name = "opis_informacije", namespace = "http://www.zahtev.com", type = JAXBElement.class),
            @XmlElementRef(name = "tip_zahteva", namespace = "http://www.zahtev.com", type = JAXBElement.class),
            @XmlElementRef(name = "datum_vreme", namespace = "http://www.zahtev.com", type = JAXBElement.class),
            @XmlElementRef(name = "nacini_dostave", namespace = "http://www.zahtev.com", type = JAXBElement.class),
            @XmlElementRef(name = "trazilac_informacije", namespace = "http://www.zahtev.com", type = JAXBElement.class)
        })
        @XmlMixed
        protected List<Serializable> content;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link ZahtevDokument.Sadrzaj.TipZahteva }{@code >}
         * {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}
         * {@link JAXBElement }{@code <}{@link ZahtevDokument.Sadrzaj.NaciniDostave }{@code >}
         * {@link JAXBElement }{@code <}{@link TtrazilacInformacije }{@code >}
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://www.zahtev.com}Tnacini_dostave">
         *       &lt;anyAttribute processContents='lax'/>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class NaciniDostave
            extends TnaciniDostave
        {

            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.zahtev.com>TTipovi_zahteva">
         *       &lt;anyAttribute processContents='lax'/>
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
        public static class TipZahteva {

            @XmlValue
            protected TTipoviZahteva value;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link TTipoviZahteva }
             *     
             */
            public TTipoviZahteva getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link TTipoviZahteva }
             *     
             */
            public void setValue(TTipoviZahteva value) {
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

}
