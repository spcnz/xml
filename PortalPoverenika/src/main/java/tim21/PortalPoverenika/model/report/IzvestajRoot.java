
package tim21.PortalPoverenika.model.report;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Izvestaj" type="{http://www.izvestaj.com}TIzvestaj"/&gt;
 *       &lt;/sequence&gt;
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

}
