package tim21.PortalPoverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.report.IzvestajRoot;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import tim21.PortalPoverenika.util.IdGenerator;

import javax.xml.namespace.QName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.REPORT_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.DBConstants.RESCRIPT_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.REPORT_TARGET_NAMESPACE;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.RESCRIPT_TARGET_NAMESPACE;

@Repository
public class ReportRepository {

    @Autowired
    ExistManager existManager;


    public IzvestajRoot create(IzvestajRoot report) {
        try {
            String id = IdGenerator.generate();

            Map<QName, String> attrributes = report.getOtherAttributes();
            attrributes.put(new QName("xsmlns"), "http://www.izvestaj.com");
            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), "http://izvestaji/" + id);
            attrributes.put(new QName("property"), "pred:year");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datum = sdf.format(new Date());
            attrributes.put(new QName("datum"), datum);
            attrributes.put(new QName("content"), datum.substring(0,4));
            if(existManager.store(REPORT_COLLECTION_URI, id, report, "izvestaji")) {
                return report;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public XMLResource getOne(String ID) {
        try {
            return existManager.getOne(REPORT_COLLECTION_URI, ID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResourceSet getAll() throws XMLDBException {
        try {
            return existManager.getAll(REPORT_COLLECTION_URI, "/IzvestajRoot", REPORT_TARGET_NAMESPACE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
