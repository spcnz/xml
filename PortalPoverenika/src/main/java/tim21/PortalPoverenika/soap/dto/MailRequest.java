
package tim21.PortalPoverenika.soap.dto;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for MailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MailRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="From" type="{http://www.mail.com}TEmail"/&gt;
 *         &lt;element name="To" type="{http://www.mail.com}TEmail"/&gt;
 *         &lt;element name="Subject" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="File" type="{http://www.w3.org/2001/XMLSchema}anyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MailRequest", propOrder = {
    "from",
    "to",
    "subject",
    "content",
    "file",
        "html"
})
@XmlRootElement(name="mail")
public class MailRequest {

    @XmlElement(name = "From", required = true, namespace = "http://www.mail.com")
    protected String from;
    @XmlElement(name = "To", required = true,  namespace = "http://www.mail.com")
    protected String to;
    @XmlElement(name = "Subject", required = true,  namespace = "http://www.mail.com")
    protected String subject;
    @XmlElement(name = "Content", required = true,  namespace = "http://www.mail.com")
    protected String content;
    @XmlElement(name = "File", required = true,  namespace = "http://www.mail.com")
    protected Object file;
    @XmlElement(name = "Html", required = true,  namespace = "http://www.mail.com")
    protected Object html;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFile(Object value) {
        this.file = value;
    }

    public Object getHtml() {
        return html;
    }

    /**
     * Sets the value of the file property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setHtml(Object value) {
        this.html = value;
    }

}
