package tim21.EmailApp.soap.endpoints;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tim21.EmailApp.soap.service.MailServiceSoapBindingImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private MailServiceSoapBindingImpl mailServiceSoapBinding;


    @Bean
    public Endpoint mailEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, mailServiceSoapBinding);
        endpoint.publish("/mail");
        return endpoint;
    }


}
