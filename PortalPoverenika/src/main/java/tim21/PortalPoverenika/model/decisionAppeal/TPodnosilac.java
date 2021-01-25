
package tim21.PortalPoverenika.model.decisionAppeal;

import tim21.PortalPoverenika.model.shared.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.shared.com}TFizicko_lice">
 *       &lt;sequence>
 *         &lt;element name="Kontakt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac", namespace = "http://www.zalbanaodluku.com", propOrder = {
    "kontakt"
})
public class TPodnosilac
    extends TFizickoLice
{

    @XmlElement(name = "Kontakt", namespace = "http://www.zalbanaodluku.com", required = true)
    protected String kontakt;

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKontakt(String value) {
        this.kontakt = value;
    }

}
