package rs.ac.uns.ftn.examples.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

public class ZahtevWriter {


    private static String TARGET_NAMESPACE = "http://www.zahtevcir.com";

    private static String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";

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
        Element zahtevDokument = document.createElementNS(TARGET_NAMESPACE, "zahtev_dokument");
        document.appendChild(zahtevDokument);

        zahtevDokument.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.zahtevcir.com ../doc/xsd/zavrsni_rad.xsd");


        Element nadlezniOrgan = document.createElementNS(TARGET_NAMESPACE, "nadlezni_organ");
        zahtevDokument.appendChild(nadlezniOrgan);

        Element naziv = document.createElementNS(TARGET_NAMESPACE, "naziv");
        nadlezniOrgan.appendChild(naziv);

        Element sediste = document.createElementNS(TARGET_NAMESPACE, "sediste");
        nadlezniOrgan.appendChild(sediste);

        zahtevDokument.appendChild(nadlezniOrgan);

        Element naslov = document.createElementNS(TARGET_NAMESPACE, "naslov");
        naslov.appendChild(document.createTextNode("З А Х Т Е В  за приступ информацији од јавног значаја"));
        zahtevDokument.appendChild(naslov);

        Element sadrzaj = document.createElementNS(TARGET_NAMESPACE, "sadrzaj");
        zahtevDokument.appendChild(sadrzaj);


        Element izborZahteva = document.createElementNS(TARGET_NAMESPACE, "izbor_zahteva");
        sadrzaj.appendChild(izborZahteva);
        Element zahtev1 = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        zahtev1.appendChild(document.createTextNode("обавештење да ли поседује тражену информацију"));
        izborZahteva.appendChild(zahtev1);
        Element zahtev2 = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        zahtev2.appendChild(document.createTextNode("увид у документ који садржи тражену информацију"));
        izborZahteva.appendChild(zahtev2);
        Element zahtev3 = document.createElementNS(TARGET_NAMESPACE, "zahtev");
        zahtev3.appendChild(document.createTextNode("копију документа који садржи тражену информацију"));
        izborZahteva.appendChild(zahtev3);

        Element naciniDostave = document.createElementNS(TARGET_NAMESPACE, "nacini_dostave");
        sadrzaj.appendChild(naciniDostave);

        Element nacin1 = document.createElementNS(TARGET_NAMESPACE, "nacin");
        nacin1.appendChild(document.createTextNode("поштом"));
        naciniDostave.appendChild(nacin1);
        Element nacin2 = document.createElementNS(TARGET_NAMESPACE, "nacin");
        nacin2.appendChild(document.createTextNode("електронском поштом"));
        naciniDostave.appendChild(nacin2);
        Element nacin3 = document.createElementNS(TARGET_NAMESPACE, "nacin");
        nacin3.appendChild(document.createTextNode("факсом"));
        naciniDostave.appendChild(nacin1);
        Element nacin4 = document.createElementNS(TARGET_NAMESPACE, "nacin");
        nacin4.appendChild(document.createTextNode("на други начин:***"));
        Element unosNacina = document.createElementNS(TARGET_NAMESPACE, "unos_nacina");
        nacin4.appendChild(unosNacina);
        naciniDostave.appendChild(nacin4);

        Element opisInformacije = document.createElementNS(TARGET_NAMESPACE, "opis_informacije");
        sadrzaj.appendChild(opisInformacije);

        Element trazilacInformacije = document.createElementNS(TARGET_NAMESPACE, "trazilac_informacije");
        Element ime = document.createElementNS(TARGET_NAMESPACE, "ime");
        trazilacInformacije.appendChild(ime);

        Element prezime = document.createElementNS(TARGET_NAMESPACE, "ime");
        trazilacInformacije.appendChild(prezime);

        Element adresa = document.createElementNS(TARGET_NAMESPACE, "adresa");
        trazilacInformacije.appendChild(adresa);

        Element drugiPodaci = document.createElementNS(TARGET_NAMESPACE, "drugi_podaci_za_kontakt");
        trazilacInformacije.appendChild(drugiPodaci);
        sadrzaj.appendChild(trazilacInformacije);

        Element datumVreme = document.createElementNS(TARGET_NAMESPACE, "datum_vreme");
        Element sat = document.createElementNS(TARGET_NAMESPACE, "sat");
        datumVreme.appendChild(sat);

        Element minut = document.createElementNS(TARGET_NAMESPACE, "minut");
        datumVreme.appendChild(minut);

        Element dan = document.createElementNS(TARGET_NAMESPACE, "dan");
        datumVreme.appendChild(dan);
        Element mesec = document.createElementNS(TARGET_NAMESPACE, "mesec");
        datumVreme.appendChild(mesec);

        Element godina = document.createElementNS(TARGET_NAMESPACE, "godina");
        datumVreme.appendChild(godina);
        sadrzaj.appendChild(datumVreme);

        Element fusnote = document.createElementNS(TARGET_NAMESPACE, "fusnote");
        Element fusnota1 = document.createElementNS(TARGET_NAMESPACE, "fusnota");
        fusnota1.appendChild(document.createTextNode("* У кућици означити која законска права на приступ информацијама желите да остварите."));
        Element fusnota2 = document.createElementNS(TARGET_NAMESPACE, "fusnota");
        fusnota2.appendChild(document.createTextNode("** У кућици означити начин достављања копије докумената."));
        Element fusnota3 = document.createElementNS(TARGET_NAMESPACE, "fusnota");
        fusnota3.appendChild(document.createTextNode("*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате."));

        fusnote.appendChild(fusnota1);
        fusnote.appendChild(fusnota2);
        fusnote.appendChild(fusnota3);

        zahtevDokument.appendChild(fusnote);

    }

    /**
     * Serializes DOM tree to an arbitrary OutputStream.
     */
    public void transform(OutputStream out) {
        try {

            // Kreiranje instance objekta zaduzenog za serijalizaciju DOM modela
            Transformer transformer = transformerFactory.newTransformer();

            // Indentacija serijalizovanog izlaza
            transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Nad "source" objektom (DOM stablo) vrši se transformacija
            DOMSource source = new DOMSource(document);

            // Rezultujući stream (argument metode)
            StreamResult result = new StreamResult(out);

            // Poziv metode koja vrši opisanu transformaciju
            transformer.transform(source, result);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "../doc/xml/zahtevcir.xml";

            System.out.println("[INFO] No input file, using default \""	+ filePath + "\"");

        } else {
            filePath = args[0];
        }

        ZahtevWriter handler = new ZahtevWriter();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        handler.transform(System.out);

		/*
		try {
			handler.transform(new FileOutputStream("data/xml/zavrsni_rad_out_3.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
    }
}
