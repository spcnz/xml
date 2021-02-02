package tim21.PortalPoverenika.soap.endpoints;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tim21.PortalPoverenika.soap.service.decisionAppeal.DecisionAppealServiceSoapBindingImpl;
import tim21.PortalPoverenika.soap.service.silenceAppeal.SilenceAppealServiceSoapBindingImpl;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private DecisionAppealServiceSoapBindingImpl decisionAppealServiceSoapBinding;

    @Autowired
    private SilenceAppealServiceSoapBindingImpl silenceAppealServiceSoapBinding;


    @Bean
    public Endpoint decisionAppealEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, decisionAppealServiceSoapBinding);
        endpoint.publish("/decision-appeal");
        return endpoint;
    }

    @Bean
    public Endpoint silenceAppealEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, silenceAppealServiceSoapBinding);
        endpoint.publish("/silence-appeal");
        return endpoint;
    }


}
