package tim21.PortalPoverenika.soap.service.report;

import tim21.PortalPoverenika.model.report.ObjectFactory;
import tim21.PortalPoverenika.model.report.TIzvestaj;
import tim21.PortalPoverenika.model.report.TResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-03T18:20:06.219+01:00
 * Generated source version: 3.2.1
 * 
 */
@WebService(targetNamespace = "http://www.izvestaj.com", name = "ReportServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ReportServicePortType {

    @WebMethod(action = "http://www.izvestaj.com/ws/getAppealStats")
    @WebResult(name = "Izvestaj", targetNamespace = "http://www.izvestaj.com", partName = "Izvestaj")
    public TIzvestaj getAppealStats();

    @WebMethod(action = "http://www.izvestaj.com/ws/submitReport")
    @WebResult(name = "response", targetNamespace = "http://www.izvestaj.com", partName = "response")
    public TResponse submitReport(
            @WebParam(partName = "izvestaj", name = "izvestaj", targetNamespace = "")
                    TIzvestaj izvestaj
    );
}
