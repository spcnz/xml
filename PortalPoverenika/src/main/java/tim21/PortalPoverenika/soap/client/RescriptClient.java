package tim21.PortalPoverenika.soap.client;


import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import tim21.PortalPoverenika.model.rescript.TResenje;
import tim21.PortalPoverenika.soap.dto.TResponse;


@Service
public class RescriptClient extends WebServiceGatewaySupport {

    public boolean submitRescript(TResenje rescript) {

        String uri = "http://localhost:8083/ws/rescript";
        TResponse response = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, rescript,
                        new SoapActionCallback(
                                "http://www.resenje.com/ws/submitRescript"));

        if (response.getStatus().equals("SUCCESS")) {
            return true;
        } else {
            return false;
        }
    }
}
