package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.lists.SilenceAppealList;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.repository.SilenceAppealRepository;
import tim21.PortalPoverenika.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;


@Service
public class SilenceAppealService {

    @Autowired
    SilenceAppealRepository appealRepository;

    public boolean create(ZalbaCutanjeRoot appeal) {
        if (Validator.validate(appeal.getClass(), appeal)){
            return appealRepository.create(appeal);
        }
        return false;
    }

    public SilenceAppealList getAll() throws XMLDBException, JAXBException {
        List<ZalbaCutanjeRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZalbaCutanjeRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaCutanjeRoot appeal = (ZalbaCutanjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new SilenceAppealList(appeals);
    }

    public ZalbaCutanjeRoot getOne(String ID) {
        XMLResource xmlResource = appealRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ZalbaCutanjeRoot appeal = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ZalbaCutanjeRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            appeal = (ZalbaCutanjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return appeal;
    }
}
