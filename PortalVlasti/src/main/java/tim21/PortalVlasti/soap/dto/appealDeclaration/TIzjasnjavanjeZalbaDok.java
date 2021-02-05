
package tim21.PortalVlasti.soap.dto.appealDeclaration;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for TIzjasnjavanjeZalbaDok complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIzjasnjavanjeZalbaDok"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID_Zalbe" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="Odgovor" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIzjasnjavanjeZalbaDok", propOrder = {
    "idZalbe",
    "odgovor"
})
@XmlRootElement(name= "IzjasnjavanjeZalbaDokument")
public class TIzjasnjavanjeZalbaDok {

    @XmlElement(name = "ID_Zalbe", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idZalbe;
    @XmlElement(name = "Odgovor", required = true)
    protected String odgovor;

    /**
     * Gets the value of the idZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIDZalbe() {
        return idZalbe;
    }

    /**
     * Sets the value of the idZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIDZalbe(BigInteger value) {
        this.idZalbe = value;
    }

    /**
     * Gets the value of the odgovor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOdgovor() {
        return odgovor;
    }

    /**
     * Sets the value of the odgovor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOdgovor(String value) {
        this.odgovor = value;
    }

}
