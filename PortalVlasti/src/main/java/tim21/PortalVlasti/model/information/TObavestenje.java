
package tim21.PortalVlasti.model.information;

import tim21.PortalVlasti.model.shared.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


/**
 * <p>Java class for TObavestenje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TObavestenje">
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TObavestenje", namespace = "http://www.obavestenje.com", propOrder = {
    "organ",
    "brojPredmeta",
    "datum",
    "podnosilac",
    "naslov",
    "podnaslov",
    "odgovor",
    "podaciOPlacanju",
    "dostavljeno"
})
public class TObavestenje {

    @XmlElement(name = "Organ", required = true)
    protected TObavestenje.Organ organ;
    @XmlElement(name = "Broj_predmeta", required = true)
    protected TObavestenje.BrojPredmeta brojPredmeta;
    @XmlElement(name = "Datum", required = true)
    protected TObavestenje.Datum datum;
    @XmlElement(name = "Podnosilac", required = true)
    protected TObavestenje.Podnosilac podnosilac;
    @XmlElement(name = "Naslov", required = true)
    protected String naslov;
    @XmlElement(name = "Podnaslov", required = true)
    protected String podnaslov;
    @XmlElement(name = "Odgovor", required = true)
    protected TObavestenje.Odgovor odgovor;
    @XmlElement(name = "Podaci_o_placanju", required = true)
    protected TObavestenje.PodaciOPlacanju podaciOPlacanju;
    @XmlElement(name = "Dostavljeno", required = true)
    protected TObavestenje.Dostavljeno dostavljeno;

    /**
     * Gets the value of the organ property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.Organ }
     *     
     */
    public TObavestenje.Organ getOrgan() {
        return organ;
    }

    /**
     * Sets the value of the organ property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.Organ }
     *     
     */
    public void setOrgan(TObavestenje.Organ value) {
        this.organ = value;
    }

    /**
     * Gets the value of the brojPredmeta property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.BrojPredmeta }
     *     
     */
    public TObavestenje.BrojPredmeta getBrojPredmeta() {
        return brojPredmeta;
    }

    /**
     * Sets the value of the brojPredmeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.BrojPredmeta }
     *     
     */
    public void setBrojPredmeta(TObavestenje.BrojPredmeta value) {
        this.brojPredmeta = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.Datum }
     *     
     */
    public TObavestenje.Datum getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.Datum }
     *     
     */
    public void setDatum(TObavestenje.Datum value) {
        this.datum = value;
    }

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.Podnosilac }
     *     
     */
    public TObavestenje.Podnosilac getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.Podnosilac }
     *     
     */
    public void setPodnosilac(TObavestenje.Podnosilac value) {
        this.podnosilac = value;
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
     * Gets the value of the odgovor property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.Odgovor }
     *     
     */
    public TObavestenje.Odgovor getOdgovor() {
        return odgovor;
    }

    /**
     * Sets the value of the odgovor property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.Odgovor }
     *     
     */
    public void setOdgovor(TObavestenje.Odgovor value) {
        this.odgovor = value;
    }

    /**
     * Gets the value of the podaciOPlacanju property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.PodaciOPlacanju }
     *     
     */
    public TObavestenje.PodaciOPlacanju getPodaciOPlacanju() {
        return podaciOPlacanju;
    }

    /**
     * Sets the value of the podaciOPlacanju property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.PodaciOPlacanju }
     *     
     */
    public void setPodaciOPlacanju(TObavestenje.PodaciOPlacanju value) {
        this.podaciOPlacanju = value;
    }

    /**
     * Gets the value of the dostavljeno property.
     * 
     * @return
     *     possible object is
     *     {@link TObavestenje.Dostavljeno }
     *     
     */
    public TObavestenje.Dostavljeno getDostavljeno() {
        return dostavljeno;
    }

    /**
     * Sets the value of the dostavljeno property.
     * 
     * @param value
     *     allowed object is
     *     {@link TObavestenje.Dostavljeno }
     *     
     */
    public void setDostavljeno(TObavestenje.Dostavljeno value) {
        this.dostavljeno = value;
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
        protected TObavestenje.Odgovor.GodinaZahteva godinaZahteva;
        @XmlElement(name = "Opis_trazene_informacije", namespace = "http://www.obavestenje.com", required = true)
        protected String opisTrazeneInformacije;
        @XmlElement(name = "Datum", namespace = "http://www.obavestenje.com", required = true)
        protected TObavestenje.Odgovor.Datum datum;
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
         *     {@link TObavestenje.Odgovor.GodinaZahteva }
         *     
         */
        public TObavestenje.Odgovor.GodinaZahteva getGodinaZahteva() {
            return godinaZahteva;
        }

        /**
         * Sets the value of the godinaZahteva property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.Odgovor.GodinaZahteva }
         *     
         */
        public void setGodinaZahteva(TObavestenje.Odgovor.GodinaZahteva value) {
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
         *     {@link TObavestenje.Odgovor.Datum }
         *     
         */
        public TObavestenje.Odgovor.Datum getDatum() {
            return datum;
        }

        /**
         * Sets the value of the datum property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.Odgovor.Datum }
         *     
         */
        public void setDatum(TObavestenje.Odgovor.Datum value) {
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
        protected TObavestenje.PodaciOPlacanju.PojedinacniTroskovi pojedinacniTroskovi;
        @XmlElement(name = "Ukupni_troskovi", namespace = "http://www.obavestenje.com", required = true)
        protected TObavestenje.PodaciOPlacanju.UkupniTroskovi ukupniTroskovi;
        @XmlElement(name = "Broj_racuna", namespace = "http://www.obavestenje.com", required = true)
        protected TObavestenje.PodaciOPlacanju.BrojRacuna brojRacuna;
        @XmlElement(name = "Poziv_na_broj", namespace = "http://www.obavestenje.com", required = true)
        protected TObavestenje.PodaciOPlacanju.PozivNaBroj pozivNaBroj;

        /**
         * Gets the value of the pojedinacniTroskovi property.
         * 
         * @return
         *     possible object is
         *     {@link TObavestenje.PodaciOPlacanju.PojedinacniTroskovi }
         *     
         */
        public TObavestenje.PodaciOPlacanju.PojedinacniTroskovi getPojedinacniTroskovi() {
            return pojedinacniTroskovi;
        }

        /**
         * Sets the value of the pojedinacniTroskovi property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.PodaciOPlacanju.PojedinacniTroskovi }
         *     
         */
        public void setPojedinacniTroskovi(TObavestenje.PodaciOPlacanju.PojedinacniTroskovi value) {
            this.pojedinacniTroskovi = value;
        }

        /**
         * Gets the value of the ukupniTroskovi property.
         * 
         * @return
         *     possible object is
         *     {@link TObavestenje.PodaciOPlacanju.UkupniTroskovi }
         *     
         */
        public TObavestenje.PodaciOPlacanju.UkupniTroskovi getUkupniTroskovi() {
            return ukupniTroskovi;
        }

        /**
         * Sets the value of the ukupniTroskovi property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.PodaciOPlacanju.UkupniTroskovi }
         *     
         */
        public void setUkupniTroskovi(TObavestenje.PodaciOPlacanju.UkupniTroskovi value) {
            this.ukupniTroskovi = value;
        }

        /**
         * Gets the value of the brojRacuna property.
         * 
         * @return
         *     possible object is
         *     {@link TObavestenje.PodaciOPlacanju.BrojRacuna }
         *     
         */
        public TObavestenje.PodaciOPlacanju.BrojRacuna getBrojRacuna() {
            return brojRacuna;
        }

        /**
         * Sets the value of the brojRacuna property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.PodaciOPlacanju.BrojRacuna }
         *     
         */
        public void setBrojRacuna(TObavestenje.PodaciOPlacanju.BrojRacuna value) {
            this.brojRacuna = value;
        }

        /**
         * Gets the value of the pozivNaBroj property.
         * 
         * @return
         *     possible object is
         *     {@link TObavestenje.PodaciOPlacanju.PozivNaBroj }
         *     
         */
        public TObavestenje.PodaciOPlacanju.PozivNaBroj getPozivNaBroj() {
            return pozivNaBroj;
        }

        /**
         * Sets the value of the pozivNaBroj property.
         * 
         * @param value
         *     allowed object is
         *     {@link TObavestenje.PodaciOPlacanju.PozivNaBroj }
         *     
         */
        public void setPozivNaBroj(TObavestenje.PodaciOPlacanju.PozivNaBroj value) {
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
            protected List<TObavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak> trosak;

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
             * {@link TObavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak }
             * 
             * 
             */
            public List<TObavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak> getTrosak() {
                if (trosak == null) {
                    trosak = new ArrayList<TObavestenje.PodaciOPlacanju.PojedinacniTroskovi.Trosak>();
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
