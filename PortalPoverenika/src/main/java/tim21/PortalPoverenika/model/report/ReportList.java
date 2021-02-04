
package tim21.PortalPoverenika.model.report;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

import org.apache.jena.reasoner.ValidityReport;
import org.w3c.dom.Element;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;


/**
 * <p>Java class for ReportList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */


@XmlRootElement
@XmlSeeAlso({IzvestajRoot.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportList", propOrder = {
        "any"
})
public class ReportList {

    @XmlAnyElement
    protected List<IzvestajRoot> any;

    public ReportList(List<IzvestajRoot> reports){
        this.any = reports;
    }

    public ReportList() {this.any = new ArrayList<>(); }
    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<IzvestajRoot> getAny() {
        if (any == null) {
            any = new ArrayList<IzvestajRoot>();
        }
        return this.any;
    }

}
