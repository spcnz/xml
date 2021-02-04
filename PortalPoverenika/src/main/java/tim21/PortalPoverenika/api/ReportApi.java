package tim21.PortalPoverenika.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.XMLDBException;
import tim21.PortalPoverenika.model.report.IzvestajRoot;
import tim21.PortalPoverenika.model.report.ReportList;
import tim21.PortalPoverenika.service.MetaDataService;
import tim21.PortalPoverenika.service.ReportDataService;

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tim21.PortalPoverenika.util.constants.RDFConstants.REPORT_RDF_RESOURCES;

@RestController
@RequestMapping(value = "/api/report", produces = MediaType.APPLICATION_XML_VALUE)
public class ReportApi {

    @Autowired
    ReportDataService reportService;

    @Autowired
    MetaDataService metaDataService;

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
