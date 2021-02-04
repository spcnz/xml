package tim21.PortalVlasti.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalVlasti.soap.dto.MailRequest;
import tim21.PortalVlasti.soap.dto.TResponse;


public class MailClient extends WebServiceGatewaySupport {

    public boolean sendMail(MailRequest request) {

        String uri = "http://localhost:8094/ws/mail";
        TResponse response = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, request,
                        new SoapActionCallback(
                                "http://www.mail.com/ws/sendEmail"));

        if (response.getStatus().equals("SUCCESS")) {
            return true;
        } else {
            return false;
        }
    }
}
