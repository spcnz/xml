package tim21.PortalPoverenika.model.lists;

import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanje;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({ZalbaCutanje.class})
public class SilenceAppealList {

    private List<ZalbaCutanje> appeals = new ArrayList<>();

    public SilenceAppealList(List<ZalbaCutanje> appeals){
        this.appeals = appeals;
    }

    public SilenceAppealList(){}

    @XmlAnyElement
    public List<ZalbaCutanje> getAppeals() {
        return appeals;
    }
}