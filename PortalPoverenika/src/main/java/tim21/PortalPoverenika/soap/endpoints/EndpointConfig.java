package tim21.PortalPoverenika.soap.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim21.PortalPoverenika.soap.service.decisionAppeal.DecisionAppealServiceSoapBindingImpl;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private DecisionAppealServiceSoapBindingImpl decisionAppealServiceSoapBinding;


    @Bean
    public Endpoint decisionAppealEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, decisionAppealServiceSoapBinding);
        endpoint.publish("/decision-appeal");
        return endpoint;
    }


}
