package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.rescript.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import static tim21.PortalPoverenika.util.constants.DBConstants.RESCRIPT_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.RESCRIPT_TARGET_NAMESPACE;

@Repository
public class RescriptRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(Resenje rescript) {
        try {
            //Ovde izmeni documentID
            return existManager.store(RESCRIPT_COLLECTION_URI, rescript.getID().replace("/",""), rescript);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
            return existManager.getAll(RESCRIPT_COLLECTION_URI, "/Resenje", RESCRIPT_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
