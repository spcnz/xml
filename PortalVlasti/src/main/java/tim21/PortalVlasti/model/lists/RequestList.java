package tim21.PortalVlasti.model.lists;

import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.model.request.ZahtevRoot;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({ZahtevRoot.class})
public class RequestList {

    private List<ZahtevRoot> requests = new ArrayList<>();

    public RequestList(List<ZahtevRoot> requests){
        this.requests = requests;
    }

    public RequestList(){}

    @XmlAnyElement
    public List<ZahtevRoot> getRequests() {
        return requests;
    }
}