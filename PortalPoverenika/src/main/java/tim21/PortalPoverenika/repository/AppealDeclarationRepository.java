package tim21.PortalPoverenika.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.db.ExistManager;
import tim21.PortalPoverenika.model.appealDeclaration.IzjasnjavanjeZalba;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.util.IdGenerator;

import javax.xml.namespace.QName;
import java.util.Map;

import static tim21.PortalPoverenika.util.constants.DBConstants.APPEAL_DECLARATION_COLLECTION_URI;
import static tim21.PortalPoverenika.util.constants.NamespaceConstants.APPEAL_DECLARATION_NAMESPACE;
import static tim21.PortalPoverenika.util.constants.XSDConstants.APPEAL_DECLARATION;

@Repository
public class AppealDeclarationRepository {

    @Autowired
    public ExistManager existManager;


    public IzjasnjavanjeZalba create(IzjasnjavanjeZalba declaration) {
        try {
            String id = IdGenerator.generate();
            String aboutValue = "http://izjasnjavanja/" + id;
            Map<QName, String> attrributes = declaration.getOtherAttributes();

            attrributes.put(new QName("id"), id);
            attrributes.put(new QName("about"), aboutValue);

            if(existManager.store(APPEAL_DECLARATION_COLLECTION_URI, id , declaration, "izjasnjavanja")){
                return declaration;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public XMLResource getByAppeal(String appealID) throws Exception {

        String xpath = "/IzjasnjavanjeZalba[descendant::ID_Zalbe=" + appealID + "]";
        System.out.println(xpath);
        ResourceSet list =  existManager.getAll(APPEAL_DECLARATION_COLLECTION_URI, xpath, APPEAL_DECLARATION_NAMESPACE);

        if(list.getSize() != 0) {
            return (XMLResource) list.getResource(0);
        } else {
            return null;
        }
    }
}
