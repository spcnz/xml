package tim21.PortalVlasti.model.lists;

import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.model.request.ZahtevDokument;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({ZahtevDokument.class})
public class RequestList {

    private List<ZahtevDokument> requests = new ArrayList<>();

    public RequestList(List<ZahtevDokument> requests){
        this.requests = requests;
    }

    public RequestList(){}

    @XmlAnyElement
    public List<ZahtevDokument> getRequests() {
        return requests;
    }
}