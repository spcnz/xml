package tim21.PortalVlasti.model.auth;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "User")
public class AuthUserRequest {

    @XmlElement(required = true)
    protected String email;

    @XmlElement(required = true)
    protected String password;

    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
}