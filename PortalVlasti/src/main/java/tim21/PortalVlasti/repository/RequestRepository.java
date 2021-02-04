package tim21.PortalVlasti.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.db.ExistManager;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.util.IdGenerator;
import tim21.PortalVlasti.util.constants.XSDConstants;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalVlasti.util.constants.DBConstants.REQUEST_COLLECTION_URI;
import static tim21.PortalVlasti.util.constants.NamespaceConstants.REQUEST_TARGET_NAMESPACE;

@Repository
public class RequestRepository {

    @Autowired
    public ExistManager existManager;

    enum REQUEST_STATUS {
        PROCESS("PROCESS"),
        REJECTED("REJECTED"),
        ACCEPTED("ACCEPTED");

        public final String label;

        private REQUEST_STATUS(String label) {
            this.label = label;
        }
    }

    public boolean create(ZahtevRoot request) {
        try {
            String id = IdGenerator.generateDocumentID(IdGenerator.generate(XSDConstants.REQUEST), XSDConstants.REQUEST);
            Map<QName, String> attrributes = request.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("status"), REQUEST_STATUS.PROCESS.label);

            return existManager.store(REQUEST_COLLECTION_URI, id, request, "zahtevi");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(REQUEST_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(REQUEST_COLLECTION_URI, "/zahtev_dokument", REQUEST_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
