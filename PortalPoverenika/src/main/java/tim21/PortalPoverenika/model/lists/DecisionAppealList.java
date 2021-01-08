package tim21.PortalPoverenika.model.lists;

import tim21.PortalPoverenika.model.decisionAppeal.Zalba;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({Zalba.class})
public class DecisionAppealList {

    private List<Zalba> appeals = new ArrayList<>();

    public DecisionAppealList(List<Zalba> appeals){
        this.appeals = appeals;
    }

    public DecisionAppealList(){}

    @XmlAnyElement
    public List<Zalba> getAppeals() {
        return appeals;
    }
}