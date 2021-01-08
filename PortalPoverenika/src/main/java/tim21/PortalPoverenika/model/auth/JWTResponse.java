package tim21.PortalPoverenika.model.auth;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "JWT")
public class JWTResponse {

    @XmlElement(required = true)
    protected String token;

    @XmlElement(required = true)
    protected int expiresIn;

    public JWTResponse(String token, int expiresIn){
        this.token = token;
        this.expiresIn = expiresIn;
    }

    public JWTResponse() {}

}