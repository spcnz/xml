package tim21.PortalPoverenika.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {

    private static String date;

    public static String generate(String className) {
        date = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        date = date.replace(".", "");

        return date;
    }

    public static String generateDocumentID(String id, String className) {

        return className + id + ".xml";
    }
}
