
package tim21.PortalVlasti.model.report;

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
 *         &lt;element name="Izvestaj" type="{http://www.izvestaj.com}TIzvestaj"/&gt;
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
        "izvestaj"
})
@XmlRootElement(name = "IzvestajRoot")
public class IzvestajRoot {

    @XmlElement(name = "Izvestaj", required = true)
    protected TIzvestaj izvestaj;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the izvestaj property.
     *
     * @return
     *     possible object is
     *     {@link TIzvestaj }
     *
     */
    public TIzvestaj getIzvestaj() {
        return izvestaj;
    }

    /**
     * Sets the value of the izvestaj property.
     *
     * @param value
     *     allowed object is
     *     {@link TIzvestaj }
     *
     */
    public void setIzvestaj(TIzvestaj value) {
        this.izvestaj = value;
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
