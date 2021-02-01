package tim21.PortalPoverenika.model.lists;

import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({ZalbaRoot.class})
public class DecisionAppealList {

    private List<ZalbaRoot> appeals = new ArrayList<>();

    public DecisionAppealList(List<ZalbaRoot> appeals){
        this.appeals = appeals;
    }

    public DecisionAppealList(){}

    @XmlAnyElement
    public List<ZalbaRoot> getAppeals() {
        return appeals;
    }
}