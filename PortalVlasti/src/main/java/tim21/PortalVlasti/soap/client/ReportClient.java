package tim21.PortalVlasti.soap.client;

import tim21.PortalVlasti.model.report.TIzvestaj;
import tim21.PortalVlasti.soap.dto.MailRequest;

public class ReportClient {

    public TIzvestaj getAppealStats() {

        String uri = "http://localhost:8080/ws/report";
        //TIzvestaj res = (TIzvestaj)

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
        return null;
    }
}
