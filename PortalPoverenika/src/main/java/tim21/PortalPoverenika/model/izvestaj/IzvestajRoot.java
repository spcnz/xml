
package tim21.PortalPoverenika.model.izvestaj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Izvestaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{}TIzvestaj">
 *                 &lt;sequence>
 *                   &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
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
    "izvestaj"
})
@XmlRootElement(name = "IzvestajRoot")
public class IzvestajRoot {

    @XmlElement(name = "Izvestaj", required = true)
    protected IzvestajRoot.Izvestaj izvestaj;

    /**
     * Gets the value of the tim21.PortalPoverenika.model.izvestaj property.
     * 
     * @return
     *     possible object is
     *     {@link IzvestajRoot.Izvestaj }
     *     
     */
    public IzvestajRoot.Izvestaj getIzvestaj() {
        return izvestaj;
    }

    /**
     * Sets the value of the tim21.PortalPoverenika.model.izvestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link IzvestajRoot.Izvestaj }
     *     
     */
    public void setIzvestaj(IzvestajRoot.Izvestaj value) {
        this.izvestaj = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{}TIzvestaj">
     *       &lt;sequence>
     *         &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "brojZahteva",
        "brojOdbijenihZahteva",
        "brojZalbiOdluka",
        "brojZalbiCutanje"
    })
    public static class Izvestaj
        extends TIzvestaj
    {

        @XmlElement(name = "BrojZahteva")
        protected int brojZahteva;
        @XmlElement(name = "BrojOdbijenihZahteva")
        protected int brojOdbijenihZahteva;
        @XmlElement(name = "BrojZalbiOdluka")
        protected int brojZalbiOdluka;
        @XmlElement(name = "BrojZalbiCutanje")
        protected int brojZalbiCutanje;

        /**
         * Gets the value of the brojZahteva property.
         * 
         */
        public int getBrojZahteva() {
            return brojZahteva;
        }

        /**
         * Sets the value of the brojZahteva property.
         * 
         */
        public void setBrojZahteva(int value) {
            this.brojZahteva = value;
        }

        /**
         * Gets the value of the brojOdbijenihZahteva property.
         * 
         */
        public int getBrojOdbijenihZahteva() {
            return brojOdbijenihZahteva;
        }

        /**
         * Sets the value of the brojOdbijenihZahteva property.
         * 
         */
        public void setBrojOdbijenihZahteva(int value) {
            this.brojOdbijenihZahteva = value;
        }

        /**
         * Gets the value of the brojZalbiOdluka property.
         * 
         */
        public int getBrojZalbiOdluka() {
            return brojZalbiOdluka;
        }

        /**
         * Sets the value of the brojZalbiOdluka property.
         * 
         */
        public void setBrojZalbiOdluka(int value) {
            this.brojZalbiOdluka = value;
        }

        /**
         * Gets the value of the brojZalbiCutanje property.
         * 
         */
        public int getBrojZalbiCutanje() {
            return brojZalbiCutanje;
        }

        /**
         * Sets the value of the brojZalbiCutanje property.
         * 
         */
        public void setBrojZalbiCutanje(int value) {
            this.brojZalbiCutanje = value;
        }

    }

}
