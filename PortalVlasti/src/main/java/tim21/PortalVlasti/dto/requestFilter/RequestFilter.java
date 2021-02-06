
package tim21.PortalVlasti.dto.requestFilter;

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
    "submitter",
    "institutionName",
    "institutionOffice",
    "requestType",
    "delivery",
    "submitterName",
    "submitterLastname",
    "appealDate"
})
@XmlRootElement(name = "RequestFilter", namespace = "http://www.shared.com")
public class RequestFilter {

    @XmlElement(name = "Submitter", namespace = "", required = true)
    protected String submitter;
    @XmlElement(name = "InstitutionName", namespace = "", required = true)
    protected String institutionName;
    @XmlElement(name = "InstitutionOffice", namespace = "", required = true)
    protected String institutionOffice;
    @XmlElement(name = "RequestType", namespace = "", required = true)
    protected String requestType;
    @XmlElement(name = "Delivery", namespace = "", required = true)
    protected String delivery;
    @XmlElement(name = "SubmitterName", namespace = "", required = true)
    protected String submitterName;
    @XmlElement(name = "SubmitterLastname", namespace = "", required = true)
    protected String submitterLastname;
    @XmlElement(name = "AppealDate", namespace = "", required = true)
    protected String appealDate;

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionOffice() {
        return institutionOffice;
    }

    public void setInstitutionOffice(String institutionOffice) {
        this.institutionOffice = institutionOffice;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getSubmitterLastname() {
        return submitterLastname;
    }

    public void setSubmitterLastname(String submitterLastname) {
        this.submitterLastname = submitterLastname;
    }

    public String getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(String appealDate) {
        this.appealDate = appealDate;
    }
}
