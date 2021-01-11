package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.decisionAppeal.Zalba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import static tim21.PortalPoverenika.util.constants.DBConstants.DECISIONAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.DECISIONAPPEAL_TARGET_NAMESPACE;

@Repository
public class DecisionAppealRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(Zalba appeal) {
        try {

            return existManager.store(DECISIONAPPEAL_COLLECTION_URI, "test.xml", appeal);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveFromText(String text) throws Exception {
        existManager.storeFromText(DECISIONAPPEAL_COLLECTION_URI, "ZalbaOdluka", text);
    }

    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(DECISIONAPPEAL_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(DECISIONAPPEAL_COLLECTION_URI, "/Zalba", DECISIONAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
