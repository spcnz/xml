package tim21.PortalVlasti.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.db.ExistManager;
import tim21.PortalVlasti.model.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalVlasti.util.IdGenerator;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalVlasti.util.constants.DBConstants.APPEAL_ANNOUNCEMENT_COLLECTION_URI;
import static tim21.PortalVlasti.util.constants.NamespaceConstants.APPEAL_ANNOUNCEMENT_TARGET_NAMESPACE;
import static tim21.PortalVlasti.util.constants.XSDConstants.APPEAL_ANNOUNCEMENT;

@Repository
public class AppealAnnouncementRepository {

    @Autowired
    public ExistManager existManager;


    public ObavestenjeZalba create(ObavestenjeZalba announcement) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://zalbeObavestenja/" + id;
            Map<QName, String> attrributes = announcement.getOtherAttributes();
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);

            if (existManager.store(APPEAL_ANNOUNCEMENT_COLLECTION_URI, id, announcement, "zalbeObavestenja")) {
                return announcement;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(APPEAL_ANNOUNCEMENT_COLLECTION_URI, "/ObavestenjeZalba", APPEAL_ANNOUNCEMENT_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

