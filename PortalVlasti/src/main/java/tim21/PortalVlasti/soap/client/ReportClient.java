package tim21.PortalVlasti.soap.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalVlasti.model.report.TIzvestaj;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import tim21.PortalVlasti.model.report.TResponse;

@Service
public class ReportClient extends WebServiceGatewaySupport {

    public TIzvestaj getAppealStats() {

        String uri = "http://localhost:8080/ws/report";


        TIzvestaj res = (TIzvestaj) getWebServiceTemplate()
                .marshalSendAndReceive(uri, null,
                        new SoapActionCallback(
                                "http://www.izvestaj.com/ws/getAppealStats"));

        System.out.println(res.getPravnoLice().getBrojZalbiCutanje());

        System.out.println(res.getFizickoLice().getBrojZalbiCutanje());

        System.out.println(res.getFizickoLice().getBrojZahteva());

        System.out.println(res.getPravnoLice().getBrojZalbiCutanje());
        System.out.println(res.getPravnoLice().getBrojZahteva());
        return res;
    }

    public TResponse submitReport(TIzvestaj report){


        TResponse res = (TResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/report", report,
                        new SoapActionCallback(
                                "http://www.report.com/ws/submitReport"));

        System.out.println("OVOOO VRACA " + res.getStatus());
        return res;

    }

}
