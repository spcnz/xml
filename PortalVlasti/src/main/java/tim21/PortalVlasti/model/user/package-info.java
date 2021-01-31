@javax.xml.bind.annotation.XmlSchema(elementFormDefault = XmlNsForm.QUALIFIED,
        namespace = "http://user.com",
        xmlns={@XmlNs(prefix="u", namespaceURI="http://user.com"),
                @XmlNs(prefix="sh", namespaceURI="http://www.shared.com"),
                @XmlNs(prefix="pred", namespaceURI="http://www.tim21.com/predicate/")})

package tim21.PortalVlasti.model.user;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;