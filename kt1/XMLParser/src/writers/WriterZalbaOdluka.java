package writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriterZalbaOdluka extends DOMWriter {

	private static String TARGET_NAMESPACE = "http://www.zalbanaodluku.com";

	private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
	
	private static DocumentBuilderFactory factory;
	
	private Document document;
	
	/*
	 * Factory initialization static-block
	 */
	static {
		factory = DocumentBuilderFactory.newInstance();
	}
	
	/**
	 * Generates document object model for a given XML file.
	 */
	@Override
	public void createDocument() {

		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// Kreiranje novog dokumenta 
			document = builder.newDocument(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates sample document object model 
	 * programmatically using DOM API methods. 
	 */
	@Override
	public void generateDOM() {
		
		// Kreiranje i postavljanje korenskog elementa
		Element zalba = document.createElementNS(TARGET_NAMESPACE, "za:Zalba");
		document.appendChild(zalba);

		zalba.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.zalbanaodluku.com ../xsd/zalbanaodluku.xsd");
		
		Element naslov = document.createElementNS(TARGET_NAMESPACE, "Naslov");
		zalba.appendChild(naslov);
		zalba.appendChild(document.createTextNode("ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ \n" +
				"        ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ"));
	}

	
	public static void main(String args[]) {

		String filePath = null;

		System.out.println("[INFO] DOM Parser");

		if (args.length != 1) {

			filePath = "data/xml/zalbanaodluku.xml";

			System.out.println("[INFO] No input file, using default \""	+ filePath + "\"");

		} else {
			filePath = args[0];
		}

		WriterZalbaOdluka handler = new WriterZalbaOdluka();

		// Kreiranje Document čvora
		handler.createDocument();

		// Generisanje DOM stabla
		handler.generateDOM();

		try {
			handler.transform(new FileOutputStream("data/xml/zalbanaodluku_out.xml"), handler.document);
		} catch ( FileNotFoundException e) {
			System.out.println("[INFO] Can't find output file");
			e.printStackTrace();
		}
	}
}
