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
import tim21.PortalPoverenika.model.report.IzvestajRoot;
import tim21.PortalPoverenika.model.report.ReportList;
import tim21.PortalPoverenika.repository.ReportRepository;
import tim21.PortalPoverenika.util.Validator;
import tim21.PortalPoverenika.util.transformer.PDFTransformer;

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

    public static final String XSL_FILE = "src/main/resources/xsl/report.xsl";

    public static final String XSL_FO_FILE = "src/main/resources/xsl/report_fo.xsl";


    public IzvestajRoot create(IzvestajRoot report) throws IOException, SAXException {

        if (Validator.validate(report.getClass(), report)){

            return reportRepository.create(report);
        }
        return null;
    }


    public ReportList getAll() throws XMLDBException, JAXBException {
        List<IzvestajRoot> reports = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = reportRepository.getAll();
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
            System.out.println(report.getIzvestaj().getFizickoLice().getBrojZalbiOdluka() + " KLJUC REPO ");

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


    public String generatePdf(String ID) {
        XMLResource inf = reportRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if(inf == null)
            return null;

        String pdfPath ="src/main/resources/static/information/information_" + ID + ".pdf";
        try {
            transformer.generatePDF(inf.getContent().toString(), pdfPath, XSL_FO_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return pdfPath;
    }

    public String generateHtml(String ID) {
        XMLResource inf = reportRepository.getOne(ID);
        PDFTransformer transformer = new PDFTransformer();

        if (inf == null)
            return null;

        String htmlPath = "src/main/resources/static/information/information_" + ID + ".html";
        try {
            transformer.generateHTML(inf.getContent().toString(), htmlPath, XSL_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return htmlPath;
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
