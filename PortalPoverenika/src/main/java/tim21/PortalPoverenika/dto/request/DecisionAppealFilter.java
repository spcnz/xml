
package tim21.PortalPoverenika.dto.request;

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
 *         &lt;element name="RecipientStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RecipientCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterLastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterCity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SubmitterStreet" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "recipientStreet",
    "recipientCity",
    "requestId",
    "submitterName",
    "submitterLastname",
    "submitterCity",
    "submitterStreet",
    "requestDate"
})
@XmlRootElement(name = "DecisionAppealFilter", namespace = "http://www.shared.com")
public class DecisionAppealFilter {

    @XmlElement(name = "RecipientStreet", namespace = "", required = true)
    protected String recipientStreet;
    @XmlElement(name = "RecipientCity", namespace = "", required = true)
    protected String recipientCity;
    @XmlElement(name = "RequestId", namespace = "", required = true)
    protected String requestId;
    @XmlElement(name = "SubmitterName", namespace = "", required = true)
    protected String submitterName;
    @XmlElement(name = "SubmitterLastname", namespace = "", required = true)
    protected String submitterLastname;
    @XmlElement(name = "SubmitterCity", namespace = "", required = true)
    protected String submitterCity;
    @XmlElement(name = "SubmitterStreet", namespace = "", required = true)
    protected String submitterStreet;
    @XmlElement(name = "RequestDate", namespace = "", required = true)
    protected String requestDate;

    /**
     * Gets the value of the recipientStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientStreet() {
        return recipientStreet;
    }

    /**
     * Sets the value of the recipientStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientStreet(String value) {
        this.recipientStreet = value;
    }

    /**
     * Gets the value of the recipientCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientCity() {
        return recipientCity;
    }

    /**
     * Sets the value of the recipientCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientCity(String value) {
        this.recipientCity = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return  !requestId.equals("") ? "http://zahtevi/" + requestId : "" ;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the submitterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterName() {
        return submitterName;
    }

    /**
     * Sets the value of the submitterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterName(String value) {
        this.submitterName = value;
    }

    /**
     * Gets the value of the submitterLastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterLastname() {
        return submitterLastname;
    }

    /**
     * Sets the value of the submitterLastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterLastname(String value) {
        this.submitterLastname = value;
    }

    /**
     * Gets the value of the submitterCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterCity() {
        return submitterCity;
    }

    /**
     * Sets the value of the submitterCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterCity(String value) {
        this.submitterCity = value;
    }

    /**
     * Gets the value of the submitterStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterStreet() {
        return submitterStreet;
    }

    /**
     * Sets the value of the submitterStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterStreet(String value) {
        this.submitterStreet = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestDate(String value) {
        this.requestDate = value;
    }

}
