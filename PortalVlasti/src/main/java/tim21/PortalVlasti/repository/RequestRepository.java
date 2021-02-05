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
import static tim21.PortalVlasti.util.constants.XSDConstants.REQUEST;

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

    public ZahtevRoot create(ZahtevRoot request, String submitterId) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://zahtevi/" + id;
            Map<QName, String> attrributes = request.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);
            attrributes.put(new QName("href"), "http://users/" + submitterId);
            attrributes.put(new QName("status"), REQUEST_STATUS.PROCESS.label);

            if(existManager.store(REQUEST_COLLECTION_URI, id, request, "zahtevi")){
                return request;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
            return existManager.getAll(REQUEST_COLLECTION_URI, "/" + REQUEST, REQUEST_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean reject(ZahtevRoot request) throws Exception {
        request.getOtherAttributes().put(new QName("status"), REQUEST_STATUS.REJECTED.label);
        if(existManager.store(REQUEST_COLLECTION_URI, request.getOtherAttributes().get(new QName("id")), request, "zahtevi")){
            return true;
        }

        return false;
    }

    public ResourceSet getAllByUser(String email) throws XMLDBException {
        try {
            String xpath = "/ZahtevRoot[@href='http://users/" + email + "']";
            System.out.println(xpath);
            return existManager.getAll(REQUEST_COLLECTION_URI, xpath, REQUEST_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
