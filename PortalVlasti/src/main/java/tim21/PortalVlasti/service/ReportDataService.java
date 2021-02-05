package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.report.IzvestajRoot;
import tim21.PortalVlasti.model.report.ReportList;
import tim21.PortalVlasti.model.report.TIzvestaj;
import tim21.PortalVlasti.repository.ReportRepository;
import tim21.PortalVlasti.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportDataService {
    
    @Autowired
    ReportRepository reportRepository;


    public IzvestajRoot create(IzvestajRoot report) throws IOException, SAXException {
        System.out.println("SAD VALIDIRA  " );
        if (Validator.validate(report.getClass(), report)){
            return reportRepository.create(report);
        }
        return null;
    }

    public IzvestajRoot createFromOld(TIzvestaj old) {
        IzvestajRoot root = new IzvestajRoot();
        root.setIzvestaj(old);
        return reportRepository.create(root);

    }

    public ReportList getAll() throws XMLDBException, JAXBException {
        List<IzvestajRoot> reports = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = reportRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(IzvestajRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            IzvestajRoot report = (IzvestajRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            reports.add(report);
        }
        return new ReportList(reports);
    }

    public IzvestajRoot getOne(String ID) {
        XMLResource xmlResource = reportRepository.getOne(ID);
        if(xmlResource == null)
            return null;

        IzvestajRoot report = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(IzvestajRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            report = (IzvestajRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return report;
    }


    public ReportList search(String keyword) throws XMLDBException, JAXBException {
        List<IzvestajRoot> reports = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = reportRepository.search(keyword);
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(IzvestajRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            IzvestajRoot report = (IzvestajRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            reports.add(report);
        }
        return new ReportList(reports);
    }
}
