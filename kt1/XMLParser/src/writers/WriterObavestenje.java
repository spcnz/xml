package writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriterObavestenje extends DOMWriter {

    private static String TARGET_NAMESPACE = "http://www.obavestenje.com";

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

    @Override
    public Document getDocument() { return document; }

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
        Element obavestenje = document.createElementNS(TARGET_NAMESPACE, "Obavestenje");
        document.appendChild(obavestenje);

        obavestenje.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.obavestenje.com ../xsd/obavestenje.xsd");

        obavestenje.setAttribute("xmlns:sh", SHARED_NAMESPACE);

        Element organ = document.createElement("Organ");
        obavestenje.appendChild(organ);

        Element naziv = document.createElement("Naziv");
        organ.appendChild(naziv);

        Element adresa = document.createElement("sh:Adresa");
        adresa.setAttribute("xmlns", SHARED_NAMESPACE);
        organ.appendChild(adresa);

        Element grad = document.createElement("Grad");
        grad.setTextContent("Novi Sad");
        Element ulica = document.createElement("Ulica");
        ulica.setTextContent("Jesenjinova");
        Element broj = document.createElement("Broj");
        broj.setTextContent("33");
        Element postanskiBroj = document.createElement("Postanski_broj");
        postanskiBroj.setTextContent("11000");
        
        adresa.appendChild(grad);
        adresa.appendChild(ulica);
        adresa.appendChild(broj);
        adresa.appendChild(postanskiBroj);
        

        Element brojPredmeta = document.createElement("Broj_predmeta");
        brojPredmeta.setTextContent("12");
        obavestenje.appendChild(brojPredmeta);
        Element datum = document.createElement("Datum");
        datum.setTextContent("2020-10-01");
        obavestenje.appendChild(datum);

        Element podnosilac = document.createElement("Podnosilac");
		Element fizickoLice = document.createElement("Fizicko_lice");
		podnosilac.appendChild(fizickoLice);

		Element ime = document.createElement("Ime");
		Element prezime = document.createElement("Prezime");
		fizickoLice.appendChild(ime);
		fizickoLice.appendChild(prezime);
		fizickoLice.appendChild(adresa.cloneNode(true));
        obavestenje.appendChild(podnosilac);

        Element naslov = document.createElement("Naslov");
		naslov.setTextContent("Obavestenje");
		obavestenje.appendChild(naslov);
        Element podnaslov = document.createElement("Podnaslov");
		podnaslov.setTextContent("Obavestenje");
		obavestenje.appendChild(podnaslov);

        Element odgovor = document.createElement("Odgovor");
        obavestenje.appendChild(odgovor);
        Element godinaZahteva = document.createElement("Godina_zahteva");
        godinaZahteva.setTextContent("2020");
        odgovor.appendChild(godinaZahteva);
        Element opisTrazeneInformacije = document.createElement("Opis_trazene_informacije");
        odgovor.appendChild(opisTrazeneInformacije);
        odgovor.appendChild(adresa.cloneNode(true));
        Element sati = document.createElement("Sati");
        sati.setTextContent("23");
        Element satiOd = document.createElement("Sati_od");
        satiOd.setTextContent("23");
        Element satiDo = document.createElement("Sati_do");
        satiDo.setTextContent("23");
        odgovor.appendChild(sati);
        odgovor.appendChild(satiOd);
        odgovor.appendChild(satiDo);
        
        
        Element lokacija = document.createElement("Lokacija");
        odgovor.appendChild(lokacija);
        lokacija.appendChild(adresa.cloneNode(true));
        Element brojKancelarije = document.createElement("Broj_kancelarije");
        brojKancelarije.setTextContent("15");
        lokacija.appendChild(brojKancelarije);

        Element podaciOPlacanju = document.createElement("Podaci_o_placanju");
        Element pojedinacniTroskovi = document.createElement("Pojedinacni_troskovi");
        Element ukupniTroskovi = document.createElement("Ukupni_troskovi");
        Element brojRacuna = document.createElement("Broj_racuna");
        Element pnb = document.createElement("Poziv_na_broj");
        Element trosak = document.createElement("Trosak");
        Element nazivTroska = document.createElement("Naziv");
        Element cena = document.createElement("Cena");
        cena.setTextContent("22");

        obavestenje.appendChild(podaciOPlacanju);
        podaciOPlacanju.appendChild(pojedinacniTroskovi);
        podaciOPlacanju.appendChild(ukupniTroskovi);
        podaciOPlacanju.appendChild(brojRacuna);
        podaciOPlacanju.appendChild(pnb);
        pojedinacniTroskovi.appendChild(trosak);
        trosak.appendChild(nazivTroska);
        trosak.appendChild(cena);
        
        Element dostavljeno = document.createElement("Dostavljeno");
        Element tacka1 = document.createElement("Tacka");
        tacka1.setAttribute("Broj", "1");
        tacka1.setTextContent("Vladimiru");
        // Element tacka2 = document.createElement("Tacka");
        // tacka2.setAttribute("Broj", "2");
        // tacka2.setTexctContent("Antonicu");

        dostavljeno.appendChild(tacka1);
        // dostavljeno.appendChild(tacka2);
        
        obavestenje.appendChild(dostavljeno);
    }

    public static void main(String args[]) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "data/xml/obavestenje.xml";

            System.out.println("[INFO] No input file, using default \""	+ filePath + "\"");

        } else {
            filePath = args[0];
        }

        WriterObavestenje handler = new WriterObavestenje();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        try {
            handler.transform(new FileOutputStream("data/xml/obavestenje_out.xml"), handler.getDocument());
        } catch ( FileNotFoundException e) {
            System.out.println("[INFO] Can't find output file");
            e.printStackTrace();
        }
    }
}
