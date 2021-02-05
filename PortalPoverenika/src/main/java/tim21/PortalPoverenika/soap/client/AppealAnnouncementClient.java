package tim21.PortalPoverenika.soap.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalPoverenika.model.rescript.TResenje;
import tim21.PortalPoverenika.soap.dto.TResponse;
import tim21.PortalPoverenika.soap.dto.appealAnnouncement.TObZalbaDokument;

@Service
public class AppealAnnouncementClient  extends WebServiceGatewaySupport {

    public boolean announceAboutAppeal(TObZalbaDokument announcement) {

        String uri = "http://localhost:8083/ws/appeal-announcement";
        TResponse response = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive(uri, announcement,
                        new SoapActionCallback(
                                "http://www.zalbaobavestenje.com/ws/submitAppealAnnouncemenet"));

        if (response.getStatus().equals("SUCCESS")) {
            return true;
        } else {
            return false;
        }
    }
}
