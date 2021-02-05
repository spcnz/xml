package tim21.PortalVlasti.soap.endpoints;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tim21.PortalVlasti.soap.service.rescript.RescriptServiceSoapBindingImpl;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private RescriptServiceSoapBindingImpl rescriptServiceSoapBinding;


    @Bean
    public Endpoint rescriptEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, rescriptServiceSoapBinding);
        endpoint.publish("/rescript");
        return endpoint;
    }


   
}
