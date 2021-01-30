package tim21.PortalVlasti.util.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XSDConstants {
    public static final String USER = "User";

    public static final String INFORMATION = "Obavestenje";

    public static final String REQUEST = "ZahtevDokument";


    public static final Map<String, String> xsdPathMap;
    static {
        Map<String, String> map = new HashMap<>();
        map.put(USER, "classpath:xsd/user.xsd");
        map.put(INFORMATION, "classpath:xsd/Obavestenje.xsd");
        map.put(REQUEST, "classpath:xsd/zahtev.xsd");
        xsdPathMap = Collections.unmodifiableMap(map);
    }
}
