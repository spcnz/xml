package tim21.PortalPoverenika.service;

import org.codehaus.stax2.validation.XMLValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.repository.DecisionAppealRepository;
import tim21.PortalPoverenika.soap.client.AppealAnnouncementClient;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument;
import tim21.PortalPoverenika.util.Validator;
import tim21.PortalPoverenika.util.ViolationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class DecisionAppealService {

    @Autowired
    DecisionAppealRepository appealRepository;

    @Autowired
    RescriptService rescriptService;


    @Autowired
    AppealAnnouncementClient announcementClient;


    @Autowired
    private Environment env;

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
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZalbaRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZalbaRoot appeal = (ZalbaRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            appeals.add(appeal);
        }
        return new DecisionAppealList(appeals);
    }

    public boolean dropAppeal(String ID) throws XMLDBException, JAXBException {
        RescriptList rescript = rescriptService.getAllByAppealId(ID);
        if (rescript.getAny().isEmpty()) {
            return appealRepository.delete(ID);
        } else {
            throw new ViolationException("Rescript for appeal have been created.");
        }
    }

    public DecisionAppealList getAllByUser(String email) throws XMLDBException, JAXBException {
        List<ZalbaRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.getAllByUser(email);
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

    public boolean notifyOffical(String appealID) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("tim21.PortalPoverenika.soap.dto.appealAnnouncement");

        announcementClient.setDefaultUri(env.getProperty("portal_vlasti"));
        announcementClient.setMarshaller(marshaller);

        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setContextPath("tim21.PortalPoverenika.soap.dto");
        announcementClient.setUnmarshaller(unmarshaller);

        ObavestenjeZalba announce = new ObavestenjeZalba();
        TObZalbaDokument announceBody = new TObZalbaDokument();
        announceBody.setIDZalbe(new BigInteger(appealID));
        announceBody.setOpis("Pristigla je zalba na odluku." );
        announceBody.setTip("ZALBA NA ODLUKU");
        announce.setObZalbaDokument(announceBody);

        return announcementClient.announceAboutAppeal(announce.getObZalbaDokument());
    }



}
