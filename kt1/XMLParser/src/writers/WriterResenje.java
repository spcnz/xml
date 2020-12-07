package writers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriterResenje extends DOMWriter {

    private static String TARGET_NAMESPACE = "http://www.resenje.com";

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
        Element resenja = document.createElementNS(TARGET_NAMESPACE, "Resenja");
        document.appendChild(resenja);

        resenja.setAttributeNS(XSI_NAMESPACE, "xsi:schemaLocation", "http://www.resenje.com ../xsd/resenje.xsd");

        resenja.setAttribute("xmlns:sh", SHARED_NAMESPACE);

        Element resenje = document.createElement("Resenje");
        resenja.appendChild(resenje);
        resenje.setAttribute("dopustena_zalba", "ne");

        Element ID = document.createElement("ID");
        ID.setTextContent("071-01-4075/2018-03");
        resenje.appendChild(ID);

        Element datum = document.createElement("Datum");
        datum.setTextContent("2020-09-10");
        resenje.appendChild(datum);

        Element statusZahteva = document.createElement("Status_zahteva");
        statusZahteva.appendChild(document.createTextNode("odbijen"));
        resenje.appendChild(statusZahteva);

        Element opisResenja = document.createElement("Opis_resenja");
        opisResenja.setTextContent("Повереник за информације од јавног значаја и заштиту података о личности, у поступку по\n" +
                "            жалби АА изјављеној због непоступања Јавног комуналног предузећа „Београдски водовод и\n" +
                "            канализација“ у Београду, по његовом захтеву за приступ информацијама од јавног значаја од\n" +
                "            05.11.2018. године, на основу члана 35. став 1. тачка 5 Закона о слободном приступу информацијама\n" +
                "            од јавног значаја („Сл. гласник РС“ бр. 120/04, 54/07, 104/09 и 36/10), а у вези са чланом 4. тачка 22.\n" +
                "            Закона о заштити података о личности („Сл. гласник РС“, број 87/2018), као и члана 23. и члана 24.\n" +
                "            ст. 1. Закона о слободном приступу информацијама од јавног значаја и члана 173. став. 2. Закона о\n" +
                "            општем управном поступку („Службени гласник РС“, бр. 18/2016 и 95/2018 –аутентично тумачење),\n" +
                "            доноси \n" +
                "                    Р Е Ш Е Њ Е\n" +
                "            \n" +
                "            Одбија се, као неоснован, захтев АА, за приступ информацијама од јавног значаја, поднет\n" +
                "            05.11.2018. године Јавном комуналном предузећу „Београдски водовод и канализација“ у Београду.");

        resenje.appendChild(opisResenja);

        Element obrazlozenje = document.createElement("Obrazlozenje");
        resenje.appendChild(obrazlozenje);

        Element opisZalbe = document.createElement("Opis_zalbe");
        obrazlozenje.appendChild(opisZalbe);
        opisZalbe.appendChild(document.createTextNode("   АА, изјавио је 26.11.2018. године жалбу Поверенику, због непоступања Јавног комуналног\n" +
                "                предузећа „Београдски водовод и канализација“ у Београду, по његовом захтеву за приступ\n" +
                "                информацијама од јавног значаја од 05.11.2018. године. Уз жалбу је приложена копија поднетог\n" +
                "                захтева са доказом о предаји органу власти"));

        Element postupakPoverenika = document.createElement("Postupak_poverenika");
        obrazlozenje.appendChild(postupakPoverenika);
        postupakPoverenika.appendChild(document.createTextNode("Поступајући по поднетој жалби Повереник је дана 28.11.2018. године доставио жалбу на\n" +
                "                изјашњење Јавном комуналном предузећу „Београдски водовод и канализација“ у Београду, као\n" +
                "                органу власти у смислу члана 3. Закона о слободном приступу информацијама од јавног значаја и\n" +
                "                затражио да се изјасни о наводима жалбе, посебно о разлозима непоступања у законском року у\n" +
                "                складу са одредбама члана 16. ст. 1-9. или ст. 10. Закона, остављајући за то рок од осам дана, поводом\n" +
                "                чега није добио одговор."));

        Element odgovorNaZalbu = document.createElement("Odgovor_na_zalbu");
        obrazlozenje.appendChild(odgovorNaZalbu);
        odgovorNaZalbu.appendChild(document.createTextNode("По разматрању жалбе и осталих списа овог предмета, донета је одлука као у диспозитиву\n" +
                "                решења из следећих разлога:"));

        Element razlozi = document.createElement("Razlozi");
        odgovorNaZalbu.appendChild(razlozi);

        Element tacka = document.createElement("sh:Tacka");
        razlozi.appendChild(tacka);
        tacka.setAttribute("broj", "1");
        tacka.appendChild(document.createTextNode("У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити. \n"));

        Element tacka2 = (Element) tacka.cloneNode(true);
        tacka2.setAttribute("broj", "2");
        razlozi.appendChild(tacka2);

        Element uputstva = document.createElement("Uputstvo_o_pravnom_sredstvu");
        obrazlozenje.appendChild(uputstva);
        uputstva.appendChild(document.createTextNode("Против овог решења није допуштена жалба већ се, у складу са Законом о управним\n" +
                "                споровима, може покренути управни спор тужбом Управном суду у Београду, у року од 30 дана од\n" +
                "                дана пријема решења. Такса на тужбу износи"));

        Element taksa = document.createElement("Taksa");
        taksa.setTextContent("342.6");
        uputstva.appendChild(taksa);

        uputstva.appendChild(document.createTextNode("динара."));

        Element poverenik = document.createElement("Poverenik");
        resenje.appendChild(poverenik);
        Element ime = document.createElement("Ime");
        ime.setAttribute("xmlns", "");
        ime.setTextContent("Milan");
        Element prezime = document.createElement("Prezime");
        prezime.setAttribute("xmlns", "");
        prezime.setTextContent("Marinovic");

        poverenik.appendChild(ime);
        poverenik.appendChild(prezime);
    }

    public static void main(String args[]) {

        String filePath = null;

        System.out.println("[INFO] DOM Parser");

        if (args.length != 1) {

            filePath = "data/xml/resenja.xml";

            System.out.println("[INFO] No input file, using default \""	+ filePath + "\"");

        } else {
            filePath = args[0];
        }

        WriterResenje handler = new WriterResenje();

        // Kreiranje Document čvora
        handler.createDocument();

        // Generisanje DOM stabla
        handler.generateDOM();

        try {
            handler.transform(new FileOutputStream("data/xml/resenja_out.xml"), handler.getDocument());
        } catch ( FileNotFoundException e) {
            System.out.println("[INFO] Can't find output file");
            e.printStackTrace();
        }
    }
}
