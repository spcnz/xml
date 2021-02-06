package tim21.PortalPoverenika.soap.client;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import tim21.PortalPoverenika.soap.dto.request.ObjectFactory;
import tim21.PortalPoverenika.soap.dto.request.TZahtev;

import javax.xml.bind.JAXBElement;

@Service
public class RequestClient extends WebServiceGatewaySupport {

    public boolean getRequest(String id) {

        String uri = "http://localhost:8083/ws/request";


        ObjectFactory factory = new ObjectFactory();

        JAXBElement<String> res = (JAXBElement<String>) getWebServiceTemplate()
                .marshalSendAndReceive(uri, factory.createRequest(id) ,
                        new SoapActionCallback(
                                "http://www.zahtev.com/ws/getById"));

        System.out.println("daaaa" + res.getValue());

        if (res.getValue() == "false") {
            return false;
        }
        return true;
    }

    public String getRequestStatus(String id) {

        String uri = "http://localhost:8083/ws/request";

        ObjectFactory factory = new ObjectFactory();

        JAXBElement<String> res = (JAXBElement<String>) getWebServiceTemplate()
                .marshalSendAndReceive(uri, factory.createRequest(id) ,
                        new SoapActionCallback(
                                "http://www.zahtev.com/ws/getStatusById"));

        System.out.println("daaaa" + res.getValue());

        return  res.getValue();
    }
}
