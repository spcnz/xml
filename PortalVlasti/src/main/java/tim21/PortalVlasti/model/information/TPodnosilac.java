
package tim21.PortalVlasti.model.information;

import tim21.PortalVlasti.model.shared.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TPodnosilac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPodnosilac">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Pravno_lice" type="{http://www.shared.com}TPravno_lice"/>
 *         &lt;element name="Fizicko_lice" type="{http://www.shared.com}TFizicko_lice"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPodnosilac", namespace = "http://www.obavestenje.com", propOrder = {
    "pravnoLice",
    "fizickoLice"
})
@XmlSeeAlso({
    TObavestenje.Podnosilac.class
})
public class TPodnosilac {

    @XmlElement(name = "Pravno_lice")
    protected TPravnoLice pravnoLice;
    @XmlElement(name = "Fizicko_lice")
    protected TFizickoLice fizickoLice;

    /**
     * Gets the value of the pravnoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TPravnoLice }
     *     
     */
    public TPravnoLice getPravnoLice() {
        return pravnoLice;
    }

    /**
     * Sets the value of the pravnoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPravnoLice }
     *     
     */
    public void setPravnoLice(TPravnoLice value) {
        this.pravnoLice = value;
    }

    /**
     * Gets the value of the fizickoLice property.
     * 
     * @return
     *     possible object is
     *     {@link TFizickoLice }
     *     
     */
    public TFizickoLice getFizickoLice() {
        return fizickoLice;
    }

    /**
     * Sets the value of the fizickoLice property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFizickoLice }
     *     
     */
    public void setFizickoLice(TFizickoLice value) {
        this.fizickoLice = value;
    }

}
