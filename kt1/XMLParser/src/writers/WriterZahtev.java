package writers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriterZahtev extends DOMWriter {


    private static String TARGET_NAMESPACE = "http://www.zahtevcir.com";

    private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

    private static String SHARED_NAMESPACE = "http://www.shared.com";

    private static DocumentBuilderFactory factory;

    private static TransformerFactory transformerFactory;

    private Document document;

    /*
     * Factory initialization static-block
     */
    static {
        factory = DocumentBuilderFactory.newInstance();

        transformerFactory = TransformerFactory.newInstance();
    }

    /**
     * Generates document object model for a given XML file.
     */
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
    public void generateDOM() {

        // Kreiranje i postavljanje korenskog elementa
        Element zahtevDokument = document.createElementNS(TARGET_NAMESPACE, "zah:zahtev_dokument");
        document.appendChild(zahtevDokument);

        zahtevDokument.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.zahtevcir.com ../xsd/zahtev.xsd");
        zahtevDokument.setAttribute("xmlns:sh", SHARED_NAMESPACE);

        Element nadlezniOrgan = document.createElement( "nadlezni_organ");
        zahtevDokument.appendChild(nadlezniOrgan);

        Element naziv = document.createElement("naziv");
        nadlezniOrgan.appendChild(naziv);

        Element sediste = document.createElement( "sediste");
        nadlezniOrgan.appendChild(sediste);

        zahtevDokument.appendChild(nadlezniOrgan);

        Element naslov = document.createElement("naslov");
        naslov.appendChild(document.createTextNode("З А Х Т Е В  за приступ информацији од јавног значаја"));
        zahtevDokument.appendChild(naslov);

        Element sadrzaj = document.createElement( "sadrzaj");
        zahtevDokument.appendChild(sadrzaj);


        Element izborZahteva = document.createElement( "izbor_zahteva");
        sadrzaj.appendChild(izborZahteva);
        Element zahtev1 = document.createElement( "zahtev");
        zahtev1.appendChild(document.createTextNode("обавештење да ли поседује тражену информацију"));
        izborZahteva.appendChild(zahtev1);
        Element zahtev2 = document.createElement( "zahtev");
        zahtev2.appendChild(document.createTextNode("увид у документ који садржи тражену информацију"));
        izborZahteva.appendChild(zahtev2);
        Element zahtev3 = document.createElement("zahtev");
        zahtev3.appendChild(document.createTextNode("копију документа који садржи тражену информацију"));
        izborZahteva.appendChild(zahtev3);

        Element naciniDostave = document.createElement( "nacini_dostave");
        sadrzaj.appendChild(naciniDostave);

        Element nacin1 = document.createElement( "nacin");
        nacin1.appendChild(document.createTextNode("поштом"));
        naciniDostave.appendChild(nacin1);
        Element nacin2 = document.createElement("nacin");
        nacin2.appendChild(document.createTextNode("електронском поштом"));
        naciniDostave.appendChild(nacin2);
        Element nacin3 = document.createElement( "nacin");
        nacin3.appendChild(document.createTextNode("факсом"));
        naciniDostave.appendChild(nacin1);
        Element nacin4 = document.createElement( "nacin");
        nacin4.appendChild(document.createTextNode("на други начин:***"));
        Element unosNacina = document.createElement( "unos_nacina");
        nacin4.appendChild(unosNacina);
        naciniDostave.appendChild(nacin4);

        Element opisInformacije = document.createElement( "opis_informacije");
        sadrzaj.appendChild(opisInformacije);

        Element trazilacInformacije = document.createElement("trazilac_informacije");
        Element ime = document.createElement("ime");
        trazilacInformacije.appendChild(ime);

        Element prezime = document.createElement("prezime");
        trazilacInformacije.appendChild(prezime);

        Element adresa = document.createElement( "adresa");
        trazilacInformacije.appendChild(adresa);

        Element drugiPodaci = document.createElement( "drugi_podaci_za_kontakt");
        trazilacInformacije.appendChild(drugiPodaci);
        sadrzaj.appendChild(trazilacInformacije);

        Element datumVreme = document.createElement( "datum_vreme");
        Element vreme = document.createElement( "vreme");
        vreme.setTextContent("09:07");
        datumVreme.appendChild(vreme);

        Element datum = document.createElement( "datum");
        datum.setTextContent("2020-09-10");
        datumVreme.appendChild(datum);
        sadrzaj.appendChild(datumVreme);

        Element fusnote = document.createElement( "fusnote");
        Element fusnota1 = document.createElement("fusnota");
        fusnota1.appendChild(document.createTextNode("* У кућици означити која законска права на приступ информацијама желите да остварите."));
        Element fusnota2 = document.createElement("fusnota");
        fusnota2.appendChild(document.createTextNode("** У кућици означити начин достављања копије докумената."));
        Element fusnota3 = document.createElement("fusnota");
        fusnota3.appendChild(document.createTextNode("*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате."));

        fusnote.appendChild(fusnota1);
        fusnote.appendChild(fusnota2);
        fusnote.appendChild(fusnota3);

        zahtevDokument.appendChild(fusnote);

    }

    @Override
    public Document getDocument() {
        return document;
    }

    /**
     * Serializes DOM tree to an arbitrary OutputStream.
     */


    public static void main(String args[]) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "data/xml/zahtevcir.xml";

            System.out.println("[INFO] No input file, using default \""	+ filePath + "\"");

        } else {
            filePath = args[0];
        }

        WriterZahtev handler = new WriterZahtev();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        try {
            handler.transform(new FileOutputStream("data/xml/zahtev_out.xml"), handler.getDocument());
        } catch ( FileNotFoundException e) {
            System.out.println("[INFO] Can't find output file");
            e.printStackTrace();
        }
		/*
		try {
			handler.transform(new FileOutputStream("data/xml/zavrsni_rad_out_3.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
    }
}
