package tim21.PortalPoverenika.dto.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "decisionAppealFilter")
public class DecisionAppealFilterDTO {
    @XmlElement(namespace = "", required = true)
    private String requestId;

    @XmlElement(namespace = "", required = true)
    private String submitterName;

    @XmlElement(namespace = "", required = true)
    private String submitterLastname;

    @XmlElement(namespace = "", required = true)
    private String submitterCity;

    @XmlElement(namespace = "", required = true)
    private String submitterStreet;

    @XmlElement(namespace = "", required = true)
    private String requestDate;

    @XmlElement(namespace = "", required = true)
    private String recipientCity;

    @XmlElement(namespace = "", required = true)
    private String recipientStreet;

    public DecisionAppealFilterDTO(String requestId, String submitterName, String submitterLastname, String submitterCity, String submitterStreet, String requestDate, String recipientCity, String recipientStreet) {
        this.requestId = "http://zahtevi/" + requestId;
        this.submitterName = submitterName;
        this.submitterLastname = submitterLastname;
        this.submitterCity = submitterCity;
        this.submitterStreet = submitterStreet;
        this.requestDate = requestDate;
        this.recipientCity = recipientCity;
        this.recipientStreet = recipientStreet;
    }

    public DecisionAppealFilterDTO() {}

    public String getRequestId() {
        return this.requestId;
    }

    public String getSubmitterName() {
        return this.submitterName;
    }

    public String getSubmitterLastname() {
        return this.submitterLastname;
    }

    public String getSubmitterCity() {
        return this.submitterCity;
    }

    public String getSubmitterStreet() {
        return this.submitterStreet;
    }

    public String getRequestDate() {
        return this.requestDate;
    }

    public String getRecipientCity() {
        return this.recipientCity;
    }

    public String getRecipientStreet() {
        return this.recipientStreet;
    }
}
