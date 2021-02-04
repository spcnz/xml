
package tim21.PortalVlasti.model.request;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zahtev_dokument" type="{http://www.zahtev.com}TZahtev"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zahtevDokument"
})
@XmlRootElement(name = "ZahtevRoot", namespace = "http://www.zahtev.com")
public class ZahtevRoot {

    @XmlElement(name = "zahtev_dokument", namespace = "http://www.zahtev.com", required = true)
    protected TZahtev zahtevDokument;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the zahtevDokument property.
     * 
     * @return
     *     possible object is
     *     {@link TZahtev }
     *     
     */
    public TZahtev getZahtevDokument() {
        return zahtevDokument;
    }

    /**
     * Sets the value of the zahtevDokument property.
     * 
     * @param value
     *     allowed object is
     *     {@link TZahtev }
     *     
     */
    public void setZahtevDokument(TZahtev value) {
        this.zahtevDokument = value;
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
