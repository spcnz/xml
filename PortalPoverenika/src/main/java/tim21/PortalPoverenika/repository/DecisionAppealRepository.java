package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.util.IdGenerator;

import javax.xml.namespace.QName;

import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.DECISIONAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.DECISIONAPPEAL_TARGET_NAMESPACE;
import static tim21.PortalPoverenika.util.constants.XSDConstants.DECISION_APPEAL;


@Repository
public class DecisionAppealRepository {

    @Autowired
    public ExistManager existManager;


    public ZalbaRoot create(ZalbaRoot appeal) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://zalbe/" + id;
            Map<QName, String> attrributes = appeal.getOtherAttributes();

            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);

            if(existManager.store(DECISIONAPPEAL_COLLECTION_URI, id , appeal, "zalbe")){
                return appeal;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    public ResourceSet search(String keyword) throws XMLDBException {
        try {
            return existManager.search(DECISIONAPPEAL_COLLECTION_URI, keyword, DECISIONAPPEAL_TARGET_NAMESPACE, DECISION_APPEAL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(String id) {
        try {
            return existManager.delete(DECISIONAPPEAL_COLLECTION_URI, id, DECISIONAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResourceSet getAllByUser(String email) throws XMLDBException {
        try {
            String xpath = "/ZalbaRoot[descendant::Podnosilac[@href='http://users/" + email + "']]";
            System.out.println(xpath);
            return existManager.getAll(DECISIONAPPEAL_COLLECTION_URI, xpath, DECISIONAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
