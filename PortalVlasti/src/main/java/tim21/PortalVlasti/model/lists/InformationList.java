package tim21.PortalVlasti.model.lists;

import tim21.PortalVlasti.model.information.Obavestenje;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Obavestenje.class})
public class InformationList {

    private List<Obavestenje> informations = new ArrayList<>();

    public InformationList(List<Obavestenje> informations){
        this.informations = informations;
    }

    public InformationList(){}

    @XmlAnyElement
    public List<Obavestenje> getInformations() {
        return informations;
    }
}