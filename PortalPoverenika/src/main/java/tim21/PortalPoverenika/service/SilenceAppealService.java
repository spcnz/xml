package tim21.PortalPoverenika.service;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.lists.SilenceAppealList;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.repository.SilenceAppealRepository;
import tim21.PortalPoverenika.soap.client.AppealAnnouncementClient;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.ObavestenjeZalba;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument;
import tim21.PortalPoverenika.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import tim21.PortalPoverenika.util.ViolationException;
import tim21.PortalPoverenika.util.transformer.PDFTransformer;

@Service
public class SilenceAppealService {

    public static final String XSL_FILE = "src/main/resources/xsl/silenceAppeal.xsl";

    public static final String XSL_FO_FILE = "src/main/resources/xsl/silenceAppeal_fo.xsl";

    @Autowired
    AppealAnnouncementClient announcementClient;

    @Autowired
    SilenceAppealRepository appealRepository;

    @Autowired
    RescriptService rescriptService;

    @Autowired
    private Environment env;

    public ZalbaCutanjeRoot create(ZalbaCutanjeRoot appeal) {
        if (Validator.validate(appeal.getClass(), appeal)){
            return appealRepository.create(appeal);
        }
        return null;
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


    public SilenceAppealList search(String keyword) throws XMLDBException, JAXBException {
        List<ZalbaCutanjeRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.search(keyword);
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

    public String generatePdf(String ID) {
        XMLResource appeal = appealRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(appeal == null)
            return null;

        String pdfPath ="src/main/resources/static/silence_appeal_" + ID + ".pdf";
        try {
            transformer.generatePDF(appeal.getContent().toString(), pdfPath, XSL_FO_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return pdfPath;
    }

    public String generateHtml(String ID) {
        XMLResource appeal = appealRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(appeal == null)
            return null;

        String htmlPath ="src/main/resources/static/silence_appeal_" + ID + ".html";
        try {
            transformer.generateHTML(appeal.getContent().toString(), htmlPath, XSL_FILE);
        } catch (XMLDBException  e) {
            e.printStackTrace();
            return null;
        }

        return htmlPath;
    }

    public boolean dropAppeal(String ID) throws XMLDBException, JAXBException {
        RescriptList rescript = rescriptService.getAllByAppealId(ID);
        if (rescript.getAny().isEmpty()) {
            return appealRepository.delete(ID);
        } else {
            throw new ViolationException("Rescript for appeal have been created.");
        }
    }

    public SilenceAppealList getAllByUser(String email) throws XMLDBException, JAXBException {
        List<ZalbaCutanjeRoot> appeals = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = appealRepository.getAllByUser(email);
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
        announceBody.setOpis("Pristigla je zalba na cutanje." );
        announceBody.setTip("ZALBA NA CUTANJE");
        announce.setObZalbaDokument(announceBody);

        return announcementClient.announceAboutAppeal(announce.getObZalbaDokument());
    }


}
