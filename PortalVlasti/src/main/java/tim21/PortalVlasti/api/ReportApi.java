package tim21.PortalVlasti.api;

import org.apache.jena.reasoner.ValidityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalVlasti.model.report.IzvestajRoot;
import tim21.PortalVlasti.model.report.ReportList;
import tim21.PortalVlasti.model.report.TIzvestaj;
import tim21.PortalVlasti.model.report.TResponse;
import tim21.PortalVlasti.service.MetaDataService;
import tim21.PortalVlasti.service.ReportDataService;
import tim21.PortalVlasti.soap.client.ReportClient;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalVlasti.util.constants.RDFConstants.REPORT_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/report", produces = MediaType.APPLICATION_XML_VALUE)
public class ReportApi {

    @Autowired
    ReportDataService reportService;

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    private Environment env;

    @Autowired
    ReportClient soapClient;

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ReportList> getAllReports() {
        ReportList reports = new ReportList();
        try {
            reports = reportService.getAll();

            return new ResponseEntity(reports, HttpStatus.OK);
        } catch (XMLDBException | JAXBException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/submit", method = RequestMethod.GET)
    public ResponseEntity<?> submitReport() {


        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("tim21.PortalVlasti.model.report");

        soapClient.setDefaultUri(env.getProperty("portal_poverenika"));
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        TIzvestaj report = soapClient.getAppealStats();
        TResponse sus = soapClient.submitReport(report);


        return new ResponseEntity<>(sus, HttpStatus.OK);

    }

    @RequestMapping(value = "/{ID}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getReport(@PathVariable String ID) {
        IzvestajRoot report = reportService.getOne(ID);
        if (report != null)
            return new ResponseEntity(report, HttpStatus.OK);

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/meta/search/{submitDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> metaSearchAppeals(@PathVariable String submitDate) {
        List<IzvestajRoot> reports = new ArrayList<IzvestajRoot>();
        List<String> res = new ArrayList<String>();
        List<String> filterVals = Arrays.asList(submitDate);
        try {
            res = metaDataService.filter("izvestaji", filterVals);
            for (String key : res) {
                String id = key.split("izvestaji")[1].substring(1);    // format keya je http://zalbe/234213123
                reports.add(reportService.getOne(id ));
            }

            ReportList response = new ReportList(reports);
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/rdf/{ID}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> metaExportRDF(@PathVariable Long ID) throws IOException {
        String path = REPORT_RDF_RESOURCES + ID + ".rdf";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/xml; charset=utf-8");
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".rdf");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/meta/json/{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> metaExportJSON(@PathVariable Long ID) throws IOException {

        String path = REPORT_RDF_RESOURCES + ID + ".json";
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Files.readAllBytes(Paths.get(path)));

            HttpHeaders headers = new HttpHeaders();

            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ID + ".json");
            return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
