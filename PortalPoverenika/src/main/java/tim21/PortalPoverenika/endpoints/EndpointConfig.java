package tim21.PortalPoverenika.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim21.PortalPoverenika.model.decisionAppeal.DecisionAppealServiceSoapBindingImpl;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;


    @Bean
    public Endpoint decisionAppealEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new DecisionAppealServiceSoapBindingImpl());
        endpoint.publish("/decision-appeal");
        return endpoint;
    }


}
