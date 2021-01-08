package tim21.PortalPoverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.user.User;

import static tim21.PortalPoverenika.util.constants.DBConstants.USER_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.USER_TARGET_NAMESPACE;

@Repository
public class UserRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(User user) {
        try {
            //ovde mitre izmenii
            return existManager.store(USER_COLLECTION_URI, user.getEmail(), user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public XMLResource getOne(String email) {
        try {
            return existManager.getOne(USER_COLLECTION_URI, email);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(USER_COLLECTION_URI, "/user", USER_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}