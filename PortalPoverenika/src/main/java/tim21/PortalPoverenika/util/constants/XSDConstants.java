package tim21.PortalPoverenika.util.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XSDConstants {
    public static final String USER = "User";

    public static final String RESCRIPT = "Resenje";

    public static final String DECISION_APPEAL = "Zalba";

    public static final String SILENCE_APPEAL = "ZalbaCutanje";

    public static final Map<String, String> xsdPathMap;
    static {
        Map<String, String> map = new HashMap<>();
        map.put(USER, "classpath:xsd/user.xsd");
        map.put(RESCRIPT, "classpath:xsd/resenje.xsd");
        map.put(DECISION_APPEAL, "classpath:xsd/zalbanaodluku.xsd");
        map.put(SILENCE_APPEAL, "classpath:xsd/zalbacutanje.xsd");
        xsdPathMap = Collections.unmodifiableMap(map);
    }
}
