package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.util.IdGenerator;
import javax.xml.namespace.QName;
import java.util.Map;
import static tim21.PortalPoverenika.util.constants.DBConstants.*;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.RESCRIPT_TARGET_NAMESPACE;
import static tim21.PortalPoverenika.util.constants.XSDConstants.RESCRIPT;

@Repository
public class RescriptRepository {

    @Autowired
    public ExistManager existManager;


    public ResenjeRoot create(ResenjeRoot rescript) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://resenja/" + id;
            rescript.getResenje().setID(id);
            Map<QName, String> attrributes = rescript.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);
            if(existManager.store(RESCRIPT_COLLECTION_URI, id, rescript, "resenja")) {
                return rescript;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(RESCRIPT_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(RESCRIPT_COLLECTION_URI, "/ResenjeRoot", RESCRIPT_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet search(String keyword) throws XMLDBException {
        try {
            return existManager.search(RESCRIPT_COLLECTION_URI, keyword, RESCRIPT_TARGET_NAMESPACE, RESCRIPT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
