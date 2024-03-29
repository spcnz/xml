
package tim21.PortalPoverenika.soap.dto.appealAnnouncement;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;


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
 *         &lt;element name="ObZalbaDokument" type="{http://www.zalbaobavestenje.com}TObZalbaDokument"/&gt;
 *       &lt;/sequence&gt;
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
    "obZalbaDokument"
})
@XmlRootElement(name = "ObavestenjeZalba")
public class ObavestenjeZalba {

    @XmlElement(name = "ObZalbaDokument", required = true)
    protected tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument obZalbaDokument;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the obZalbaDokument property.
     * 
     * @return
     *     possible object is
     *     {@link tim21.PortalVlasti.model.appealAnnouncement.TObZalbaDokument }
     *     
     */
    public tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument getObZalbaDokument() {
        return obZalbaDokument;
    }

    /**
     * Sets the value of the obZalbaDokument property.
     * 
     * @param value
     *     allowed object is
     *     {@link tim21.PortalVlasti.model.appealAnnouncement.TObZalbaDokument }
     *     
     */
    public void setObZalbaDokument(tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument value) {
        this.obZalbaDokument = value;
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
