
package tim21.PortalVlasti.model.request;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Tnacini_dostave complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tnacini_dostave">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="drugi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="POSTA" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="FAKS" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tnacini_dostave", namespace = "http://www.zahtev.com", propOrder = {
    "drugi",
    "posta",
    "email",
    "faks"
})
@XmlSeeAlso({
    TZahtev.Sadrzaj.NaciniDostave.class
})
public class TnaciniDostave {

    protected String drugi;
    @XmlElement(name = "POSTA")
    protected Object posta;
    @XmlElement(name = "EMAIL")
    protected Object email;
    @XmlElement(name = "FAKS")
    protected Object faks;

    /**
     * Gets the value of the drugi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugi() {
        return drugi;
    }

    /**
     * Sets the value of the drugi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugi(String value) {
        this.drugi = value;
    }

    /**
     * Gets the value of the posta property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPOSTA() {
        return posta;
    }

    /**
     * Sets the value of the posta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPOSTA(Object value) {
        this.posta = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEMAIL(Object value) {
        this.email = value;
    }

    /**
     * Gets the value of the faks property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFAKS() {
        return faks;
    }

    /**
     * Sets the value of the faks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFAKS(Object value) {
        this.faks = value;
    }

}
