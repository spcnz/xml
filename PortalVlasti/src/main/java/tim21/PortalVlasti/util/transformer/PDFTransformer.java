package tim21.PortalVlasti.util.transformer;

import com.itextpdf.text.DocumentException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


/**
 *
 * Primer demonstrira koriscenje iText PDF programskog API-a za
 * renderovanje PDF-a na osnovu XML dokumenta. Alternativa Apache FOP-u.
 *
 */
public class PDFTransformer {

	private static DocumentBuilderFactory documentFactory;

	private static TransformerFactory transformerFactory;

	private static FopFactory fopFactory;

	static {

		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);

		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
		try {
			fopFactory = FopFactory.newInstance(new File("src/main/java/fop.xconf"));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a PDF using iText Java API
	 * @param filePath
	 * @throws IOException
	 * @throws DocumentException
	 */

	public String generatePDF(String xmlPath, String OUTPUT_FILE, String XSL_FO_FILE) throws Exception {
		// Point to the XSL-FO file
		File xslFile = new File(XSL_FO_FILE);

		// Create transformation source
		StreamSource transformSource = new StreamSource(xslFile);

		// Initialize the transformation subject
		StreamSource source = new StreamSource(new StringReader(xmlPath));

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();

		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);

		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);


		// Resulting SAX events
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);

		// Generate PDF file
		File pdfFile = new File(OUTPUT_FILE);
		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}

		OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile));
		out.write(outStream.toByteArray());

		System.out.println("[INFO] File \"" + pdfFile.getCanonicalPath() + "\" generated successfully.");
		out.close();

		System.out.println("[INFO] End.");
		return OUTPUT_FILE;
	}


	public org.w3c.dom.Document buildDocument(String filePath) {

		org.w3c.dom.Document document = null;
		try {

			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(filePath)));

			if (document != null)
				System.out.println("[INFO] File parsed with no errors.");
			else
				System.out.println("[WARN] Document is null.");

		} catch (Exception e) {
			return null;

		}

		return document;
	}

	public String generateHTML(String xmlPath, String outputFile, String xslPath) {
		try {
			// Initialize Transformer instance
			StreamSource transformSource = new StreamSource(new File(xslPath));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Generate XHTML
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			// Transform DOM to HTML
			DOMSource source = new DOMSource(buildDocument(xmlPath));
			StreamResult result = null;
			try {
				result = new StreamResult(new FileOutputStream(outputFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
			transformer.transform(source, result);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return outputFile;
	}
}
