package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.information.Obavestenje;
import tim21.PortalVlasti.model.lists.InformationList;
import tim21.PortalVlasti.repository.InformationRepository;
import tim21.PortalVlasti.util.Validator;
import tim21.PortalVlasti.repository.InformationRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class InformationService {

    @Autowired
    InformationRepository informationRepository;


    public boolean create(Obavestenje appeal) throws IOException, SAXException {


        if (Validator.validate(appeal.getClass(), appeal)){

            return informationRepository.create(appeal);
        }
        return false;
    }


    public InformationList getAll() throws XMLDBException, JAXBException {
        List<Obavestenje> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = informationRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(Obavestenje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Obavestenje appeal = (Obavestenje) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new InformationList(appeals);
    }

    public Obavestenje getOne(String ID) {
        XMLResource xmlResource = informationRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        Obavestenje appeal = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(Obavestenje.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            appeal = (Obavestenje) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return appeal;
    }
}
