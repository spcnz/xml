
package tim21.PortalPoverenika.model.rescript;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TStatus_zalbe.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TStatus_zalbe">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ODBIJENA"/>
 *     &lt;enumeration value="PRIHVACENA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TStatus_zalbe", namespace = "http://www.resenje.com")
@XmlEnum
public enum TStatusZalbe {

    ODBIJENA,
    PRIHVACENA;

    public String value() {
        return name();
    }

    public static TStatusZalbe fromValue(String v) {
        return valueOf(v);
    }

}
