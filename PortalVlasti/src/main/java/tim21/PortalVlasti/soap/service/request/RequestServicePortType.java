package tim21.PortalVlasti.soap.service.request;

import tim21.PortalVlasti.model.request.ObjectFactory;
import tim21.PortalVlasti.model.request.TZahtev;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-06T00:24:44.796+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.zahtev.com", name = "RequestServicePortType")
@XmlSeeAlso({tim21.PortalVlasti.model.shared.ObjectFactory.class, ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface RequestServicePortType {

    @WebMethod(action = "http://www.zahtev.com/ws/getById")
    @WebResult(name = "zahtev_dokument", targetNamespace = "", partName = "zahtev_dokument")
    public TZahtev getById(
        @WebParam(partName = "id", name = "id", targetNamespace = "")
        String id
    );
}
