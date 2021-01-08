package tim21.PortalPoverenika.model.lists;

import tim21.PortalPoverenika.model.rescript.Resenje;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Resenje.class})
public class RescriptList {

    private List<Resenje> rescripts = new ArrayList<>();

    public RescriptList(List<Resenje> rescripts){
        this.rescripts = rescripts;
    }

    public RescriptList(){}

    @XmlAnyElement
    public List<Resenje> getRescripts() {
        return rescripts;
    }
}