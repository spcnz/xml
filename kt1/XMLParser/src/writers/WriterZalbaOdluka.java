package writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriterZalbaOdluka extends DOMWriter {

	private static String TARGET_NAMESPACE = "http://www.zalbanaodluku.com";

	private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

	private static String SHARED_NAMESPACE = "http://www.shared.com";
	
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

	@Override
	public void generateDOM() {
		
		// Kreiranje i postavljanje korenskog elementa
		Element zalba = document.createElementNS(TARGET_NAMESPACE, "za:Zalba");
		document.appendChild(zalba);

		zalba.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.zalbanaodluku.com ../xsd/zalbanaodluku.xsd");

		Element naslov = document.createElement("Naslov");

		naslov.appendChild(document.createTextNode("ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ \n" +
				"        ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ"));
		zalba.appendChild(naslov);

		Element primaoc = document.createElement("Primaoc");
		zalba.appendChild(primaoc);

		Element uloga = document.createElement("Uloga");
		uloga.appendChild(document.createTextNode("Поверенику за информације од јавног значаја и заштиту података о личности"));
		primaoc.appendChild(uloga);
		
		Element adresa = document.createElementNS(SHARED_NAMESPACE,"sh:Adresa");
		primaoc.appendChild(adresa);

		Element grad = document.createElement("Grad");
		grad.setTextContent("Beograd");
		adresa.appendChild(grad);

		Element ulica = document.createElement("Ulica");
		ulica.setTextContent("Булевар краља Александрa");
		adresa.appendChild(ulica);

		Element broj = document.createElement("Broj");
		broj.setTextContent("1");
		adresa.appendChild(broj);


		Element postanskiBroj = document.createElement("Postanski_broj");
		postanskiBroj.setTextContent("11000");
		adresa.appendChild(postanskiBroj);

		Element podnaslov = document.createElement("Podnaslov");
		podnaslov.setTextContent("Zalba");
		zalba.appendChild(podnaslov);

		Element fizickoLice = document.createElement("Fizicko_lice");
		zalba.appendChild(fizickoLice);

		Element ime = document.createElement("Ime");
		Element prezime = document.createElement("Prezime");
		fizickoLice.appendChild(ime);
		fizickoLice.appendChild(prezime);
		fizickoLice.appendChild(adresa.cloneNode(true));

		Element tekstZalbe = document.createElement("Tekst_zalbe");
		zalba.appendChild(tekstZalbe);
		tekstZalbe.appendChild(document.createTextNode("Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам \n" +
				"        поднео/ла-упутио/ла дана "));

		Element datumZahteva = document.createElement("Datum_podnosenja_zahteva");
		datumZahteva.setTextContent(" 2020-09-10");
		tekstZalbe.appendChild(datumZahteva);
		tekstZalbe.appendChild(document.createTextNode("године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја.\n" +
				"        Oдлуку побијам у целости, односно у делу којим"));

		Element osnovaZalbe = document.createElement("Osnova_zalbe");
		tekstZalbe.appendChild(osnovaZalbe);
		osnovaZalbe.setTextContent(" године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја.\n" +
				"        Oдлуку побијам у целости, односно у делу којим");

		zalba.appendChild(grad.cloneNode(true));
		Element datum = document.createElement("Datum");
		datum.setTextContent("2020-09-10");
		zalba.appendChild(datum);
		Element podnosilac = document.createElement("Podnosilac");
		zalba.appendChild(podnosilac);
		podnosilac.appendChild(ime.cloneNode(true));
		podnosilac.appendChild(prezime.cloneNode(true));
		podnosilac.appendChild(adresa.cloneNode(true));
		Element kontakt = document.createElement("Kontakt");
		podnosilac.appendChild(kontakt);

		Element napomena = document.createElement("Napomena");
		zalba.appendChild(napomena);

		Element tacka = document.createElement("Tacka");
		napomena.appendChild(tacka);
		tacka.setAttribute("broj", "1");
		tacka.setTextContent("У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити. \n");

		Element tacka2 = (Element) tacka.cloneNode(true);
		tacka2.setAttribute("broj", "2");
		napomena.appendChild(tacka2);
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
