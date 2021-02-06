package tim21.PortalVlasti.model.lists;

import tim21.PortalVlasti.model.information.ObavestenjeRoot;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({ObavestenjeRoot.class})
public class InformationList {

    private List<ObavestenjeRoot> informations = new ArrayList<>();

    public InformationList(List<ObavestenjeRoot> informations){
        this.informations = informations;
    }

    public InformationList(){}

    @XmlAnyElement
    public List<ObavestenjeRoot> getInformations() {
        return informations;
    }
}