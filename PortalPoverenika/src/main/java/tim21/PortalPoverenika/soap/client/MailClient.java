package tim21.PortalPoverenika.soap.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalPoverenika.soap.dto.MailRequest;
import tim21.PortalPoverenika.soap.dto.MailResponse;
import tim21.PortalPoverenika.soap.dto.TResponse;

import javax.swing.plaf.synth.SynthTextAreaUI;


public class MailClient extends WebServiceGatewaySupport {

    public boolean sendMail(MailRequest request) {

        String uri = "http://localhost:8094/ws/mail";
        TResponse response = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, request,
                        new SoapActionCallback(
                                "http://www.mail.com/ws/sendEmail"));


        System.out.println(response);
        if (response.getStatus().equals("SUCCES")) {
            return true;
        } else {
            return false;
        }
    }
}
