package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.rescript.Resenje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

import static tim21.PortalPoverenika.util.constants.DBConstants.rescriptCollectionUri;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.rescriptTargetNamespace;

@Repository
public class RescriptRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(Resenje rescript) {
        try {
            return existManager.store(rescriptCollectionUri, rescript.getID().replace("/",""), rescript);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(rescriptCollectionUri, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(rescriptCollectionUri, "/Resenje", rescriptTargetNamespace);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
