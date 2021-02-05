
package tim21.PortalVlasti.model.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

import org.w3c.dom.Element;
import tim21.PortalVlasti.model.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalVlasti.soap.dto.rescript.ResenjeRoot;


/**
 * <p>Java class for ObavestenjeZalbaList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObavestenjeZalbaList"&gt;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({ObavestenjeZalba.class})
@XmlType(name = "ObavestenjeZalbaList", propOrder = {
    "any"
})
public class AppealAnnouncementList {

    @XmlAnyElement
    protected List<ObavestenjeZalba> any;

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
    public List<ObavestenjeZalba> getAny() {
        if (any == null) {
            any = new ArrayList<ObavestenjeZalba>();
        }
        return this.any;
    }

    public AppealAnnouncementList(List<ObavestenjeZalba> any) {
        this.any = any;
    }

    public AppealAnnouncementList() {
        this.any = new ArrayList<>();
    }

}
