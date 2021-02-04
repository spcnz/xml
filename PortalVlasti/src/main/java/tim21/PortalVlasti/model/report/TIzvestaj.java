
package tim21.PortalVlasti.model.report;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for TIzvestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIzvestaj"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FizickoLice"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PravnoLice"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
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
@XmlType( propOrder = {
    "fizickoLice",
    "pravnoLice"
})
@XmlRootElement(name="Izvestaj")
public class TIzvestaj {

    @XmlElement(name = "FizickoLice", required = true,  namespace = "http://www.izvestaj.com")
    protected FizickoLice fizickoLice;
    @XmlElement(name = "PravnoLice", required = true,  namespace = "http://www.izvestaj.com")
    protected PravnoLice pravnoLice;

    /**
     * Gets the value of the fizickoLice property.
     *
     * @return
     *     possible object is
     *     {@link FizickoLice }
     *
     */
    public FizickoLice getFizickoLice() {
        return fizickoLice;
    }

    /**
     * Sets the value of the fizickoLice property.
     *
     * @param value
     *     allowed object is
     *     {@link FizickoLice }
     *
     */
    public void setFizickoLice(FizickoLice value) {
        this.fizickoLice = value;
    }

    /**
     * Gets the value of the pravnoLice property.
     *
     * @return
     *     possible object is
     *     {@link PravnoLice }
     *
     */
    public PravnoLice getPravnoLice() {
        return pravnoLice;
    }

    /**
     * Sets the value of the pravnoLice property.
     *
     * @param value
     *     allowed object is
     *     {@link PravnoLice }
     *
     */
    public void setPravnoLice(PravnoLice value) {
        this.pravnoLice = value;
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
     *         &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
        "brojZahteva",
        "brojOdbijenihZahteva",
        "brojZalbiOdluka",
        "brojZalbiCutanje"
    })
    public static class FizickoLice {

        @XmlElement(name = "BrojZahteva",namespace = "http://www.izvestaj.com")
        protected int brojZahteva;
        @XmlElement(name = "BrojOdbijenihZahteva", namespace = "http://www.izvestaj.com")
        protected int brojOdbijenihZahteva;
        @XmlElement(name = "BrojZalbiOdluka", namespace = "http://www.izvestaj.com")
        protected int brojZalbiOdluka;
        @XmlElement(name = "BrojZalbiCutanje", namespace = "http://www.izvestaj.com")
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
     *         &lt;element name="BrojZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojOdbijenihZahteva" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojZalbiOdluka" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="BrojZalbiCutanje" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
        "brojZahteva",
        "brojOdbijenihZahteva",
        "brojZalbiOdluka",
        "brojZalbiCutanje"
    })
    public static class PravnoLice {

        @XmlElement(name = "BrojZahteva", namespace = "http://www.izvestaj.com")
        protected int brojZahteva;
        @XmlElement(name = "BrojOdbijenihZahteva", namespace = "http://www.izvestaj.com")
        protected int brojOdbijenihZahteva;
        @XmlElement(name = "BrojZalbiOdluka",namespace = "http://www.izvestaj.com")
        protected int brojZalbiOdluka;
        @XmlElement(name = "BrojZalbiCutanje", namespace = "http://www.izvestaj.com")
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
