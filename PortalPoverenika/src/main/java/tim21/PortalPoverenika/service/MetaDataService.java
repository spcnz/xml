package tim21.PortalPoverenika.service;

import ch.qos.logback.core.util.FileUtil;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import tim21.PortalPoverenika.dto.request.DecisionAppealFilterDTO;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.util.rdf.AuthenticationUtilities;
import tim21.PortalPoverenika.util.rdf.MetadataExtractor;
import tim21.PortalPoverenika.util.rdf.SparqlUtil;

import javax.xml.transform.TransformerException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MetaDataService {
    private static final String RDF_FILEPATH = "src/main/resources/rdf/";
    private static final String SPARQL_PATH = "src/main/resources/sparql/";

    public static void extract(OutputStream outStream, String GRAPH_URI) throws IOException, TransformerException, SAXException {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        // Referencing XML file with RDF data in attributes


        // Automatic extraction of RDF triples from XML file
        MetadataExtractor metadataExtractor = new MetadataExtractor();
        ByteArrayInputStream input = new ByteArrayInputStream( ((ByteArrayOutputStream) outStream).toByteArray() );

        System.out.println("[INFO] Extracting metadata from RDFa attributes...");
        metadataExtractor.extractMetadata(input, GRAPH_URI);


        // Loading a default model with extracted metadata
        Model model = ModelFactory.createDefaultModel();
        model.read(RDF_FILEPATH + GRAPH_URI + ".rdf");

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        model.write(out, SparqlUtil.NTRIPLES);

        System.out.println("[INFO] Extracted metadata as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);


        // Writing the named graph
        System.out.println("[INFO] Populating named graph \"" + GRAPH_URI + "\" with extracted metadata.");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + "/" + GRAPH_URI, new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        // UpdateRequest represents a unit of execution
        UpdateRequest update = UpdateFactory.create(sparqlUpdate);

        UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
        processor.execute();



        // Read the triples from the named graph
        System.out.println();
        System.out.println("[INFO] Retrieving triples from RDF store.");
        System.out.println("[INFO] Using \"" + GRAPH_URI + "\" named graph.");

        System.out.println("[INFO] Selecting the triples from the named graph \"" + GRAPH_URI + "\".");
        String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + '/' + GRAPH_URI, "?s ?p ?o");

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");

    }


    public static List<String> filter(String GRAPH_URI, DecisionAppealFilterDTO filter) throws IOException {
        AuthenticationUtilities.ConnectionProperties conn = AuthenticationUtilities.loadProperties();

        String sparqlQuery = String.format(readFile(SPARQL_PATH + GRAPH_URI.toLowerCase() + ".rq", StandardCharsets.UTF_8), filter.getRecipientCity());

        // Create a QueryExecution that will access a SPARQL service over HTTP
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);


        // Query the collection, dump output response as XML
        ResultSet results = query.execSelect();

        List<String> res  = new ArrayList<String>();

        String varName;
        RDFNode varValue;

        while (results.hasNext()) {

            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();

            // Retrieve variable bindings
            while (variableBindings.hasNext()) {

                varName = variableBindings.next();
                varValue = querySolution.get(varName);

                System.out.println(varName + ": " + varValue);
            }
            System.out.println();
        }

        ResultSetFormatter.out(System.out, results);

        query.close() ;

        System.out.println("[INFO] End.");

        return res;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}