package tim21.PortalPoverenika.model.auth;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "User")
public class AuthUserRequest {

    @XmlElement(required = true)
    protected String email;

    @XmlElement(required = true)
    protected String password;

    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
}