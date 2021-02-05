
package tim21.PortalVlasti.soap.dto.rescript;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


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
 *         &lt;element name="Resenje" type="{http://www.resenje.com}TResenje"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dopustena_zalba" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resenje"
})
@XmlRootElement(name = "ResenjeRoot")
public class ResenjeRoot {

    @XmlElement(name = "Resenje", required = true)
    protected TResenje resenje;
    @XmlAttribute(name = "dopustena_zalba")
    @XmlSchemaType(name = "anySimpleType")
    protected String dopustenaZalba;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the resenje property.
     * 
     * @return
     *     possible object is
     *     {@link TResenje }
     *     
     */
    public TResenje getResenje() {
        return resenje;
    }

    /**
     * Sets the value of the resenje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TResenje }
     *     
     */
    public void setResenje(TResenje value) {
        this.resenje = value;
    }

    /**
     * Gets the value of the dopustenaZalba property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDopustenaZalba() {
        return dopustenaZalba;
    }

    /**
     * Sets the value of the dopustenaZalba property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDopustenaZalba(String value) {
        this.dopustenaZalba = value;
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
