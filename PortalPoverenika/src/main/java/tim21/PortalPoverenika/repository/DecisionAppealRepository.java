package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.decisionAppeal.Zalba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import static tim21.PortalPoverenika.util.constants.DBConstants.decisionAppealCollectionUri;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.decisionAppealTargetNamespace;

@Repository
public class DecisionAppealRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(Zalba appeal) {
        try {
            //ovde mitre izmenii
            return existManager.store(decisionAppealCollectionUri, "test.xml", appeal);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(decisionAppealCollectionUri, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(decisionAppealCollectionUri, "/Zalba", decisionAppealTargetNamespace);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
