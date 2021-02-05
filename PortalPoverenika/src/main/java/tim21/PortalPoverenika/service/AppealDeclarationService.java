package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.appealDeclaration.IzjasnjavanjeZalba;
import tim21.PortalPoverenika.repository.AppealDeclarationRepository;
import tim21.PortalPoverenika.util.Validator;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

@Service
public class AppealDeclarationService {

    @Autowired
    AppealDeclarationRepository declarationRepository;
    

    public IzjasnjavanjeZalba create(IzjasnjavanjeZalba declaration) throws IOException, SAXException {

        if (Validator.validate(declaration.getClass(), declaration)){

            return declarationRepository.create(declaration);
        }
        return null;
    }


    
    public IzjasnjavanjeZalba getByAppealID(String ID) throws Exception {
        XMLResource xmlResource = declarationRepository.getByAppeal(ID);

        if(xmlResource == null)
            return null;

        IzjasnjavanjeZalba declaration = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(IzjasnjavanjeZalba.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            declaration = (IzjasnjavanjeZalba) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return declaration;
    }

}
