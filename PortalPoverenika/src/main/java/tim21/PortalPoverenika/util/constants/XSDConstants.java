package tim21.PortalPoverenika.util.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XSDConstants {
    public static final String USER = "User";

    public static final String RESCRIPT = "ResenjeRoot";

    public static final String DECISION_APPEAL = "ZalbaRoot";

    public static final String SILENCE_APPEAL = "ZalbaCutanjeRoot";

    public static final String REPORT = "IzvestajRoot";

    public static final String APPEAL_DECLARATION = "IzjasnjavanjeZalba";

    public static final Map<String, String> xsdPathMap;
    static {
        Map<String, String> map = new HashMap<>();
        map.put(USER, "classpath:xsd/user.xsd");
        map.put(RESCRIPT, "classpath:xsd/resenje.xsd");
        map.put(DECISION_APPEAL, "classpath:xsd/zalbanaodluku.xsd");
        map.put(SILENCE_APPEAL, "classpath:xsd/zalbacutanje.xsd");
        map.put(REPORT, "classpath:xsd/izvestaj.xsd");
        map.put(APPEAL_DECLARATION, "classpath:xsd/IzjasnjavanjeZalba.xsd");
        xsdPathMap = Collections.unmodifiableMap(map);
    }

    public static final Map<String, String> aboutAttrMap;
    static {
        Map<String, String> map = new HashMap<>();
        map.put(USER, "users");
        map.put(RESCRIPT, "resenja");
        map.put(DECISION_APPEAL, "zalbe");
        map.put(SILENCE_APPEAL, "zalbeCutanje");
        aboutAttrMap = Collections.unmodifiableMap(map);
    }
}
