
package tim21.PortalPoverenika.soap.dto.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTipovi_zahteva.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TTipovi_zahteva"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="KOPIJA DOKUMENTA"/&gt;
 *     &lt;enumeration value="UVID U DOKUMENT"/&gt;
 *     &lt;enumeration value="OBAVESTENJE DA LI POSEDUJE INFORMACIJU"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TTipovi_zahteva")
@XmlEnum
public enum TTipoviZahteva {

    @XmlEnumValue("KOPIJA DOKUMENTA")
    KOPIJA_DOKUMENTA("KOPIJA DOKUMENTA"),
    @XmlEnumValue("UVID U DOKUMENT")
    UVID_U_DOKUMENT("UVID U DOKUMENT"),
    @XmlEnumValue("OBAVESTENJE DA LI POSEDUJE INFORMACIJU")
    OBAVESTENJE_DA_LI_POSEDUJE_INFORMACIJU("OBAVESTENJE DA LI POSEDUJE INFORMACIJU");
    private final String value;

    TTipoviZahteva(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTipoviZahteva fromValue(String v) {
        for (TTipoviZahteva c: TTipoviZahteva.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
