package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.util.IdGenerator;
import tim21.PortalPoverenika.util.constants.XSDConstants;

import javax.xml.namespace.QName;

import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.DECISIONAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.DECISIONAPPEAL_TARGET_NAMESPACE;

@Repository
public class DecisionAppealRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(ZalbaRoot appeal) {
        try {
            String id = IdGenerator.generateDocumentID(IdGenerator.generate(XSDConstants.DECISION_APPEAL), XSDConstants.DECISION_APPEAL);
            Map<QName, String> attrributes = appeal.getOtherAttributes();
            attrributes.put(new QName("id"), id);

            return existManager.store(DECISIONAPPEAL_COLLECTION_URI, id, appeal, "zalbe");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
            return existManager.getAll(DECISIONAPPEAL_COLLECTION_URI, "/ZalbaRoot", DECISIONAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
