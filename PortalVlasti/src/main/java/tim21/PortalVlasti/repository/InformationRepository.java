package tim21.PortalVlasti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.db.ExistManager;
import tim21.PortalVlasti.model.information.ObavestenjeRoot;
import tim21.PortalVlasti.util.IdGenerator;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalVlasti.util.constants.DBConstants.INFORMATION_COLLECTION_URI;
import static tim21.PortalVlasti.util.constants.NamespaceConstants.INFORMATION_TARGET_NAMESPACE;
import static tim21.PortalVlasti.util.constants.XSDConstants.INFORMATION;

@Repository
public class InformationRepository {

    @Autowired
    public ExistManager existManager;


    public ObavestenjeRoot create(ObavestenjeRoot inf) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://obavestenja/" + id;
            Map<QName, String> attrributes = inf.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);

            if (existManager.store(INFORMATION_COLLECTION_URI, id, inf, "obavestenja")) {
                return inf;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(INFORMATION_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(INFORMATION_COLLECTION_URI, "/" + INFORMATION , INFORMATION_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAllByUser(String email) throws XMLDBException {
        String xPath = "/ObavestenjeRoot[@sendTo='%s']".format(email);
        try {
            return existManager.getAll(INFORMATION_COLLECTION_URI, xPath , INFORMATION_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
