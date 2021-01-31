
package tim21.PortalVlasti.model.information;

import tim21.PortalVlasti.model.shared.*;

import java.io.Serializable;
import java.math.BigInteger;
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
 *         &lt;element name="Organ">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element ref="{http://www.shared.com}Adresa"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Broj_predmeta">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Datum">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Podnosilac">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.obavestenje.com}TPodnosilac">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Odgovor">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Godina_zahteva">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Opis_trazene_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Datum">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Sati">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="23"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Sati_od">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="23"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Sati_do">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;minInclusive value="0"/>
 *                         &lt;maxInclusive value="23"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Lokacija" type="{http://www.obavestenje.com}TLokacija"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Podaci_o_placanju">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Pojedinacni_troskovi">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="Trosak">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Ukupni_troskovi">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Broj_racuna">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.obavestenje.com>TBroj_racuna">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Poziv_na_broj">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.obavestenje.com>TPoziv_na_broj">
 *                           &lt;anyAttribute processContents='lax'/>
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Dostavljeno">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.obavestenje.com>TDostavljeno">
 *                 &lt;anyAttribute processContents='lax'/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
    "content"
})
@XmlRootElement(name = "Obavestenje", namespace = "http://www.obavestenje.com")
public class Obavestenje {

    @XmlElementRefs({
        @XmlElementRef(name = "Odgovor", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Datum", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Naslov", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Dostavljeno", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Organ", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Broj_predmeta", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Podaci_o_placanju", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Podnosilac", namespace = "http://www.obavestenje.com", type = JAXBElement.class),
        @XmlElementRef(name = "Podnaslov", namespace = "http://www.obavestenje.com", type = JAXBElement.class)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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
     * {@link JAXBElement }{@code <}{@link Obavestenje.Odgovor }{@code >}
     * {@link JAXBElement }{@code <}{@link Obavestenje.Datum }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link Obavestenje.Dostavljeno }{@code >}
     * {@link JAXBElement }{@code <}{@link Obavestenje.Organ }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link Obavestenje.BrojPredmeta }{@code >}
     * {@link JAXBElement }{@code <}{@link Obavestenje.PodaciOPlacanju }{@code >}
     * {@link JAXBElement }{@code <}{@link Obavestenje.Podnosilac }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
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
    public static class BrojPredmeta {

        @XmlValue
        protected int value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(int value) {
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
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
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
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.obavestenje.com>TDostavljeno">
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
    public static class Dostavljeno {

        @XmlValue
        protected TDostavljeno value;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link TDostavljeno }
         *     
         */
        public TDostavljeno getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link TDostavljeno }
         *     
         */
        public void setValue(TDostavljeno value) {
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
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Godina_zahteva">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Opis_trazene_informacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Datum">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Sati">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="23"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Sati_od">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="23"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Sati_do">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;minInclusive value="0"/>
     *               &lt;maxInclusive value="23"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Lokacija" type="{http://www.obavestenje.com}TLokacija"/>
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
        "godinaZahteva",
        "opisTrazeneInformacije",
        "datum",
        "sati",
        "satiOd",
        "satiDo",
        "lokacija"
    })
    public static class Odgovor {

        @XmlElement(name = "Godina_zahteva", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.Odgovor.GodinaZahteva godinaZahteva;
        @XmlElement(name = "Opis_trazene_informacije", namespace = "http://www.obavestenje.com", required = true)
        protected String opisTrazeneInformacije;
        @XmlElement(name = "Datum", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.Odgovor.Datum datum;
        @XmlElement(name = "Sati", namespace = "http://www.obavestenje.com")
        protected int sati;
        @XmlElement(name = "Sati_od", namespace = "http://www.obavestenje.com")
        protected int satiOd;
        @XmlElement(name = "Sati_do", namespace = "http://www.obavestenje.com")
        protected int satiDo;
        @XmlElement(name = "Lokacija", namespace = "http://www.obavestenje.com", required = true)
        protected TLokacija lokacija;

        /**
         * Gets the value of the godinaZahteva property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.Odgovor.GodinaZahteva }
         *     
         */
        public Obavestenje.Odgovor.GodinaZahteva getGodinaZahteva() {
            return godinaZahteva;
        }

        /**
         * Sets the value of the godinaZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.Odgovor.GodinaZahteva }
         *     
         */
        public void setGodinaZahteva(Obavestenje.Odgovor.GodinaZahteva value) {
            this.godinaZahteva = value;
        }

        /**
         * Gets the value of the opisTrazeneInformacije property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpisTrazeneInformacije() {
            return opisTrazeneInformacije;
        }

        /**
         * Sets the value of the opisTrazeneInformacije property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpisTrazeneInformacije(String value) {
            this.opisTrazeneInformacije = value;
        }

        /**
         * Gets the value of the datum property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.Odgovor.Datum }
         *     
         */
        public Obavestenje.Odgovor.Datum getDatum() {
            return datum;
        }

        /**
         * Sets the value of the datum property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.Odgovor.Datum }
         *     
         */
        public void setDatum(Obavestenje.Odgovor.Datum value) {
            this.datum = value;
        }

        /**
         * Gets the value of the sati property.
         * 
         */
        public int getSati() {
            return sati;
        }

        /**
         * Sets the value of the sati property.
         * 
         */
        public void setSati(int value) {
            this.sati = value;
        }

        /**
         * Gets the value of the satiOd property.
         * 
         */
        public int getSatiOd() {
            return satiOd;
        }

        /**
         * Sets the value of the satiOd property.
         * 
         */
        public void setSatiOd(int value) {
            this.satiOd = value;
        }

        /**
         * Gets the value of the satiDo property.
         * 
         */
        public int getSatiDo() {
            return satiDo;
        }

        /**
         * Sets the value of the satiDo property.
         * 
         */
        public void setSatiDo(int value) {
            this.satiDo = value;
        }

        /**
         * Gets the value of the lokacija property.
         * 
         * @return
         *     possible object is
         *     {@link TLokacija }
         *     
         */
        public TLokacija getLokacija() {
            return lokacija;
        }

        /**
         * Sets the value of the lokacija property.
         * 
         * @param value
         *     allowed object is
         *     {@link TLokacija }
         *     
         */
        public void setLokacija(TLokacija value) {
            this.lokacija = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
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
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>int">
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
        public static class GodinaZahteva {

            @XmlValue
            protected int value;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the value property.
             * 
             */
            public int getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             */
            public void setValue(int value) {
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
     *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element ref="{http://www.shared.com}Adresa"/>
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
        "naziv",
        "adresa"
    })
    public static class Organ {

        @XmlElement(name = "Naziv", namespace = "http://www.obavestenje.com", required = true)
        protected String naziv;
        @XmlElement(name = "Adresa", required = true)
        protected Adresa adresa;

        /**
         * Gets the value of the naziv property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaziv() {
            return naziv;
        }

        /**
         * Sets the value of the naziv property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaziv(String value) {
            this.naziv = value;
        }

        /**
         * Gets the value of the adresa property.
         * 
         * @return
         *     possible object is
         *     {@link Adresa }
         *     
         */
        public Adresa getAdresa() {
            return adresa;
        }

        /**
         * Sets the value of the adresa property.
         * 
         * @param value
         *     allowed object is
         *     {@link Adresa }
         *     
         */
        public void setAdresa(Adresa value) {
            this.adresa = value;
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
     *         &lt;element name="Pojedinacni_troskovi">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="Trosak">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Ukupni_troskovi">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Broj_racuna">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.obavestenje.com>TBroj_racuna">
     *                 &lt;anyAttribute processContents='lax'/>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Poziv_na_broj">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.obavestenje.com>TPoziv_na_broj">
     *                 &lt;anyAttribute processContents='lax'/>
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
        "pojedinacniTroskovi",
        "ukupniTroskovi",
        "brojRacuna",
        "pozivNaBroj"
    })
    public static class PodaciOPlacanju {

        @XmlElement(name = "Pojedinacni_troskovi", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.PodaciOPlacanju.PojedinacniTroskovi pojedinacniTroskovi;
        @XmlElement(name = "Ukupni_troskovi", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.PodaciOPlacanju.UkupniTroskovi ukupniTroskovi;
        @XmlElement(name = "Broj_racuna", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.PodaciOPlacanju.BrojRacuna brojRacuna;
        @XmlElement(name = "Poziv_na_broj", namespace = "http://www.obavestenje.com", required = true)
        protected Obavestenje.PodaciOPlacanju.PozivNaBroj pozivNaBroj;

        /**
         * Gets the value of the pojedinacniTroskovi property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.PodaciOPlacanju.PojedinacniTroskovi }
         *     
         */
        public Obavestenje.PodaciOPlacanju.PojedinacniTroskovi getPojedinacniTroskovi() {
            return pojedinacniTroskovi;
        }

        /**
         * Sets the value of the pojedinacniTroskovi property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.PodaciOPlacanju.PojedinacniTroskovi }
         *     
         */
        public void setPojedinacniTroskovi(Obavestenje.PodaciOPlacanju.PojedinacniTroskovi value) {
            this.pojedinacniTroskovi = value;
        }

        /**
         * Gets the value of the ukupniTroskovi property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.PodaciOPlacanju.UkupniTroskovi }
         *     
         */
        public Obavestenje.PodaciOPlacanju.UkupniTroskovi getUkupniTroskovi() {
            return ukupniTroskovi;
        }

        /**
         * Sets the value of the ukupniTroskovi property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.PodaciOPlacanju.UkupniTroskovi }
         *     
         */
        public void setUkupniTroskovi(Obavestenje.PodaciOPlacanju.UkupniTroskovi value) {
            this.ukupniTroskovi = value;
        }

        /**
         * Gets the value of the brojRacuna property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.PodaciOPlacanju.BrojRacuna }
         *     
         */
        public Obavestenje.PodaciOPlacanju.BrojRacuna getBrojRacuna() {
            return brojRacuna;
        }

        /**
         * Sets the value of the brojRacuna property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.PodaciOPlacanju.BrojRacuna }
         *     
         */
        public void setBrojRacuna(Obavestenje.PodaciOPlacanju.BrojRacuna value) {
            this.brojRacuna = value;
        }

        /**
         * Gets the value of the pozivNaBroj property.
         * 
         * @return
         *     possible object is
         *     {@link Obavestenje.PodaciOPlacanju.PozivNaBroj }
         *     
         */
        public Obavestenje.PodaciOPlacanju.PozivNaBroj getPozivNaBroj() {
            return pozivNaBroj;
        }

        /**
         * Sets the value of the pozivNaBroj property.
         * 
         * @param value
         *     allowed object is
         *     {@link Obavestenje.PodaciOPlacanju.PozivNaBroj }
         *     
         */
        public void setPozivNaBroj(Obavestenje.PodaciOPlacanju.PozivNaBroj value) {
            this.pozivNaBroj = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.obavestenje.com>TBroj_racuna">
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
        public static class BrojRacuna {

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
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="Trosak">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
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
            "trosak"
        })
        public static class PojedinacniTroskovi {

            @XmlElement(name = "Trosak", namespace = "http://www.obavestenje.com", required = true)
            protected List<Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak> trosak;

            /**
             * Gets the value of the trosak property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the trosak property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTrosak().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak }
             * 
             * 
             */
            public List<Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak> getTrosak() {
                if (trosak == null) {
                    trosak = new ArrayList<Obavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak>();
                }
                return this.trosak;
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
             *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
                "naziv",
                "cena"
            })
            public static class Trosak {

                @XmlElement(name = "Naziv", namespace = "http://www.obavestenje.com", required = true)
                protected String naziv;
                @XmlElement(name = "Cena", namespace = "http://www.obavestenje.com", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger cena;

                /**
                 * Gets the value of the naziv property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNaziv() {
                    return naziv;
                }

                /**
                 * Sets the value of the naziv property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNaziv(String value) {
                    this.naziv = value;
                }

                /**
                 * Gets the value of the cena property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getCena() {
                    return cena;
                }

                /**
                 * Sets the value of the cena property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setCena(BigInteger value) {
                    this.cena = value;
                }

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
         *     &lt;extension base="&lt;http://www.obavestenje.com>TPoziv_na_broj">
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
        public static class PozivNaBroj {

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
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>positiveInteger">
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
        public static class UkupniTroskovi {

            @XmlValue
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger value;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setValue(BigInteger value) {
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.obavestenje.com}TPodnosilac">
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
    public static class Podnosilac
        extends TPodnosilac
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

}
