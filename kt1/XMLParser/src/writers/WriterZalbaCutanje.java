package writers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriterZalbaCutanje extends DOMWriter {

    private static String TARGET_NAMESPACE = "http://www.zalbacutanje.com";

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
        Element zalba = document.createElementNS(TARGET_NAMESPACE, "zal:zalba");
        document.appendChild(zalba);

        zalba.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.zalbacutanje.com ../xsd/zalbacutanje.xsd");

        Element naziv = document.createElement( "naziv");
        zalba.appendChild(naziv);


        Element primaoc = document.createElement("primaoc");
        primaoc.setTextContent("Повереникy за информације од јавног значаја и заштиту података о личности");
        Element adresa = document.createElement("adresa");
        primaoc.appendChild(adresa);
        Element grad = document.createElement( "grad");
        grad.appendChild(document.createTextNode("Beograd"));
        Element ulica = document.createElement( "ulica");
        ulica.appendChild(document.createTextNode("Булевар краља Александрa"));
        Element broj = document.createElement("broj");
        broj.appendChild(document.createTextNode("15"));
        adresa.appendChild(grad);
        adresa.appendChild(ulica);
        adresa.appendChild(broj);

        zalba.appendChild(primaoc);

        Element sadrzaj = document.createElement("sadrzaj");
        zalba.appendChild(sadrzaj);
        sadrzaj.appendChild(document.createTextNode("У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:"));
        Element podnaslov = document.createElement("podnaslov");
        podnaslov.appendChild(document.createTextNode("Ж А Л Б У"));
        sadrzaj.appendChild(podnaslov);
        sadrzaj.appendChild(document.createTextNode("против"));

        Element nazivOrgana = document.createElement("naziv_organa");
        sadrzaj.appendChild(nazivOrgana);
        sadrzaj.appendChild(document.createTextNode("због тога што орган власти: "));

        Element razlozi = document.createElement("razlozi");
        Element opcija1 = document.createElement( "opcija");
        opcija1.setTextContent("није поступио");
        razlozi.appendChild(opcija1);

        Element opcija2 = document.createElement( "opcija");
        opcija2.setTextContent("није поступио у целости");
        razlozi.appendChild(opcija2);

        Element opcija3 = document.createElement( "opcija");
        opcija3.setTextContent("у законском року");
        razlozi.appendChild(opcija3);

        sadrzaj.appendChild(razlozi);
        sadrzaj.appendChild(document.createTextNode("(подвући  због чега се изјављује жалба)\n"));

        sadrzaj.appendChild(document.createTextNode("по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана \n"));

        Element datum = document.createElement( "datum");
        datum.setTextContent("2020-09-10");
        sadrzaj.appendChild(datum);
        sadrzaj.appendChild(document.createTextNode("године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид- копија документа који садржи информације  о /у вези са :\n"));
        Element podaciZahtev = document.createElement( "podaci_o_zahtevu");
        sadrzaj.appendChild(podaciZahtev);
        sadrzaj.appendChild(document.createTextNode("(навести податке о захтеву и информацији/ама)\n"));
        sadrzaj.appendChild(document.createTextNode("На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.\n" +
                "        Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.\n"));

        Element istaknuto = document.createElement( "istaknuto");
        istaknuto.setTextContent("Напомена:");
        sadrzaj.appendChild(istaknuto);
        sadrzaj.appendChild(document.createTextNode("Код жалбе  због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти\n"));

        Element podnosilacTuzbe = document.createElement( "podnosilac_zalbe");
        Element ime = document.createElement( "ime");
        podnosilacTuzbe.appendChild(ime);
        Element prezime = document.createElement("prezime");
        podnosilacTuzbe.appendChild(prezime);

        Element adresa2 = document.createElement("adresa");
        adresa2.appendChild(document.createElement("grad"));
        adresa2.appendChild(document.createElement("ulica"));
        adresa2.appendChild(document.createElement("broj"));
        podnosilacTuzbe.appendChild(adresa2);
        Element drugiPodaci = document.createElement( "drugi_podaci_za_kontakt");
        podnosilacTuzbe.appendChild(drugiPodaci);

        sadrzaj.appendChild(podnosilacTuzbe);


        Element datumVreme = document.createElement( "datum_vreme");
        Element vreme = document.createElement( "vreme");
        vreme.setTextContent("11:55");
        datumVreme.appendChild(vreme);

        Element datum2 = document.createElement("datum");
        datum2.setTextContent("2019-09-11");
        datumVreme.appendChild(datum2);

        sadrzaj.appendChild(datumVreme);

    }

    @Override
    public Document getDocument() {
        return document;
    }

    public static void main(String[] args) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "data/xml/zalbacutanje.xml";

            System.out.println("[INFO] No input file, using default \"" + filePath + "\"");

        } else {
            filePath = args[0];
        }

        WriterZalbaCutanje handler = new WriterZalbaCutanje();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        // Prikaz sadržaja (isprobati sa FileOutputStream-om)
        try {
            handler.transform(new FileOutputStream("data/xml/zalbacutanje_out.xml"), handler.getDocument());
        } catch (FileNotFoundException e) {
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