
package tim21.PortalPoverenika.dto.rescriptFilter;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="RequestDetails" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AppealDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "rescriptForAppeal",
    "rescriptDate",
    "appealStatus",
    "commisionerName",
    "commisionerLastname",
    "submitter"
})
@XmlRootElement(name = "RescriptFilter", namespace = "http://www.shared.com")
public class RescriptFilter {

    @XmlElement(name = "RescriptForAppeal", namespace = "", required = true)
    protected String rescriptForAppeal;
    @XmlElement(name = "RescriptDate", namespace = "", required = true)
    protected String rescriptDate;
    @XmlElement(name = "AppealStatus", namespace = "", required = true)
    protected String appealStatus;
    @XmlElement(name = "CommisionerName", namespace = "", required = true)
    protected String commisionerName;
    @XmlElement(name = "CommisionerLastname", namespace = "", required = true)
    protected String commisionerLastname;
    @XmlElement(name = "Submitter", namespace = "", required = true)
    protected String submitter;

    /**
     * Gets the value of the recipientStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRescriptForAppeal() {
        return rescriptForAppeal;
    }

    public void setRescriptForAppeal(String value) { this.rescriptForAppeal = value; }

    public String getRescriptDate() {
        return rescriptDate;
    }

    public void setRescriptDate(String rescriptDate) {
        this.rescriptDate = rescriptDate;
    }

    public String getAppealStatus() {
        return appealStatus;
    }

    public void setAppealStatus(String appealStatus) {
        this.appealStatus = appealStatus;
    }

    public String getCommisionerName() {
        return commisionerName;
    }

    public void setCommisionerName(String commisionerName) {
        this.commisionerName = commisionerName;
    }

    public String getCommisionerLastname() {
        return commisionerLastname;
    }

    public void setCommisionerLastname(String commisionerLastname) {
        this.commisionerLastname = commisionerLastname;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String value) {
        this.submitter = value;
    }

}
