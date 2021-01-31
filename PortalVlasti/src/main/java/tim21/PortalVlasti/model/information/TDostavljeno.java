
package tim21.PortalVlasti.model.information;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDostavljeno.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TDostavljeno">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IMENOVANOM"/>
 *     &lt;enumeration value="ARHIVI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TDostavljeno", namespace = "http://www.obavestenje.com")
@XmlEnum
public enum TDostavljeno {

    IMENOVANOM,
    ARHIVI;

    public String value() {
        return name();
    }

    public static TDostavljeno fromValue(String v) {
        return valueOf(v);
    }

}
