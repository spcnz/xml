package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.repository.DecisionAppealRepository;
import tim21.PortalPoverenika.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DecisionAppealService {

    @Autowired
    DecisionAppealRepository appealRepository;



    public ZalbaRoot create(ZalbaRoot appeal) throws IOException, SAXException {

        if (Validator.validate(appeal.getClass(), appeal)){

            return appealRepository.create(appeal);
        }
        return null;
    }


    public DecisionAppealList getAll() throws XMLDBException, JAXBException {
        List<ZalbaRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZalbaRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaRoot appeal = (ZalbaRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new DecisionAppealList(appeals);
    }

    public ZalbaRoot getOne(String ID) {
        XMLResource xmlResource = appealRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ZalbaRoot appeal = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ZalbaRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            appeal = (ZalbaRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return appeal;
    }


    public DecisionAppealList search(String keyword) throws XMLDBException, JAXBException {
        List<ZalbaRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.search(keyword);
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZalbaRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaRoot appeal = (ZalbaRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new DecisionAppealList(appeals);
    }
}
