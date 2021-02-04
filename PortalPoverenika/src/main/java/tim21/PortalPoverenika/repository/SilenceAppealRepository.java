package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.util.IdGenerator;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.DECISIONAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.DBConstants.SILENCEAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.*;

@Repository
public class SilenceAppealRepository {

    @Autowired
    public ExistManager existManager;


    public ZalbaCutanjeRoot create(ZalbaCutanjeRoot appeal) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://zalbeCutanje/" + id;
            Map<QName, String> attrributes = appeal.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);

            if(existManager.store(SILENCEAPPEAL_COLLECTION_URI, id, appeal, "zalbeCutanje")){
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
            return existManager.getOne(SILENCEAPPEAL_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(SILENCEAPPEAL_COLLECTION_URI, "/ZalbaCutanjeRoot", SILENCEAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ResourceSet search(String keyword) throws XMLDBException {
        try {
            return existManager.search(SILENCEAPPEAL_COLLECTION_URI, keyword, SILENCEAPPEAL_TARGET_NAMESPACE, SILENCEAPPEAL_ROOT_EL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(String id) {
        try {
            return existManager.delete(SILENCEAPPEAL_COLLECTION_URI, id, SILENCEAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
