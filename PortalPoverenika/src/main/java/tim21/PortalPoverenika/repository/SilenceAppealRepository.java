package tim21.PortalPoverenika.repository;

import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.util.IdGenerator;
import tim21.PortalPoverenika.util.constants.XSDConstants;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.SILENCEAPPEAL_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.SILENCEAPPEAL_TARGET_NAMESPACE;

@Repository
public class SilenceAppealRepository {

    @Autowired
    public ExistManager existManager;


    public boolean create(ZalbaCutanje appeal) {
        try {
            String id = IdGenerator.generateDocumentID(IdGenerator.generate(XSDConstants.SILENCE_APPEAL),XSDConstants.SILENCE_APPEAL);
            Map<QName, String> attrributes = appeal.getOtherAttributes();
            attrributes.put(new QName("id"), id);

            return existManager.store(SILENCEAPPEAL_COLLECTION_URI, id, appeal, "zalbe");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
            return existManager.getAll(SILENCEAPPEAL_COLLECTION_URI, "/zalbaCutanje", SILENCEAPPEAL_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
