
package tim21.PortalPoverenika.model.silenceAppeal;
import tim21.PortalPoverenika.model.shared.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primaoc" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="sadrzaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="razlozi">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="opcija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="datum">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="istaknuto" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="podnosilac_zalbe" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="datum_vreme" type="{http://www.shared.com}Tdatum_vreme"/>
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
    "naziv",
    "primaoc",
    "sadrzaj"
})
@XmlRootElement(name = "zalbaCutanje", namespace = "http://www.zalbacutanje.com")
public class ZalbaCutanje {

    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected Object primaoc;
    @XmlElement(required = true)
    protected ZalbaCutanje.Sadrzaj sadrzaj;

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
     * Gets the value of the primaoc property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPrimaoc() {
        return primaoc;
    }

    /**
     * Sets the value of the primaoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPrimaoc(Object value) {
        this.primaoc = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.Sadrzaj }
     *     
     */
    public ZalbaCutanje.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.Sadrzaj }
     *     
     */
    public void setSadrzaj(ZalbaCutanje.Sadrzaj value) {
        this.sadrzaj = value;
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
     *         &lt;element name="podnaslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="razlozi">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="opcija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="datum">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="istaknuto" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="podnosilac_zalbe" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
            @XmlElementRef(name = "podnosilac_zalbe", type = JAXBElement.class),
            @XmlElementRef(name = "podnaslov", type = JAXBElement.class),
            @XmlElementRef(name = "datum_vreme", type = JAXBElement.class),
            @XmlElementRef(name = "istaknuto", type = JAXBElement.class),
            @XmlElementRef(name = "datum", type = JAXBElement.class),
            @XmlElementRef(name = "razlozi", type = JAXBElement.class),
            @XmlElementRef(name = "podaci_o_zahtevu", type = JAXBElement.class),
            @XmlElementRef(name = "naziv_organa", type = JAXBElement.class)
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
         * {@link JAXBElement }{@code <}{@link Object }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link TdatumVreme }{@code >}
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
         * {@link JAXBElement }{@code <}{@link ZalbaCutanje.Sadrzaj.Razlozi }{@code >}
         * {@link JAXBElement }{@code <}{@link String }{@code >}
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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="opcija" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "opcija"
        })
        public static class Razlozi {

            protected List<String> opcija;

            /**
             * Gets the value of the opcija property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the opcija property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOpcija().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getOpcija() {
                if (opcija == null) {
                    opcija = new ArrayList<String>();
                }
                return this.opcija;
            }

        }

    }

}
