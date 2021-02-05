package tim21.PortalVlasti.soap.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalVlasti.soap.dto.TResponse;
import tim21.PortalVlasti.soap.dto.appealDeclaration.IzjasnjavanjeZalba;

@Service
public class AppealDeclarationClient extends WebServiceGatewaySupport {

    public boolean submitAppealDeclaration(IzjasnjavanjeZalba declaration) {

        String uri = "http://localhost:8080/ws/declare";
        TResponse response = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, declaration.getIzjasnjavanjeZalbaDokument(),
                        new SoapActionCallback(
                                "http://www.izjasnjavanjezalba.com/ws/declareAppealService"));

        System.out.println(response.getStatus());
        if (response.getStatus().equals("SUCCESS")) {
            return true;
        } else {
            return false;
        }
    }
}
