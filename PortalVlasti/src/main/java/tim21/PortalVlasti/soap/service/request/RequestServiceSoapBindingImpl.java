
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim21.PortalVlasti.soap.service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim21.PortalVlasti.model.request.TZahtev;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.service.RequestService;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-06T00:24:44.701+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "RequestService",
                      portName = "RequestServiceSoapBinding",
                      targetNamespace = "http://www.zahtev.com",
                      wsdlLocation = "classpath:wsdl/Request.wsdl",
                      endpointInterface = "tim21.PortalVlasti.soap.service.request.RequestServicePortType")

@Service
public class RequestServiceSoapBindingImpl implements RequestServicePortType {

    @Autowired
    RequestService service;

    private static final Logger LOG = Logger.getLogger(RequestServiceSoapBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.zahtev.RequestServicePortType#getById(java.lang.String id)*
     */
    public TZahtev getById(String id) {
        LOG.info("Executing operation getById");
        System.out.println(id);
        try {

            ZahtevRoot rootEl = service.getOne(id);


            return rootEl.getZahtevDokument();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
