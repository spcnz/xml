
package tim21.PortalVlasti.soap.dto.appealDeclaration;

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
 *         &lt;element name="IzjasnjavanjeZalbaDokument" type="{http://www.izjasnjavanjezalba.com}TIzjasnjavanjeZalbaDok"/&gt;
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
    "izjasnjavanjeZalbaDokument"
})
@XmlRootElement(name = "IzjasnjavanjeZalba")
public class IzjasnjavanjeZalba {

    @XmlElement(name = "IzjasnjavanjeZalbaDokument", required = true)
    protected TIzjasnjavanjeZalbaDok izjasnjavanjeZalbaDokument;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the izjasnjavanjeZalbaDokument property.
     * 
     * @return
     *     possible object is
     *     {@link TIzjasnjavanjeZalbaDok }
     *     
     */
    public TIzjasnjavanjeZalbaDok getIzjasnjavanjeZalbaDokument() {
        return izjasnjavanjeZalbaDokument;
    }

    /**
     * Sets the value of the izjasnjavanjeZalbaDokument property.
     * 
     * @param value
     *     allowed object is
     *     {@link TIzjasnjavanjeZalbaDok }
     *     
     */
    public void setIzjasnjavanjeZalbaDokument(TIzjasnjavanjeZalbaDok value) {
        this.izjasnjavanjeZalbaDokument = value;
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
