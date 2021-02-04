package tim21.PortalPoverenika.soap.client;

import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalPoverenika.soap.dto.MailRequest;
import tim21.PortalPoverenika.soap.dto.TResponse;


public class ReportClient {

    public boolean sendMail(MailRequest request) {

        String uri = "http://localhost:8094/ws/mail";
//        TResponse response = (TResponse) getWebServiceTemplate()
//                .marshalSendAndReceive(uri, request,
//                        new SoapActionCallback(
//                                "http://www.mail.com/ws/sendEmail"));
//
//        if (response.getStatus().equals("SUCCESS")) {
//            return true;
//        } else {
//            return false;
//        }
        return true;
    }
}
