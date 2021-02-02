package tim21.EmailApp.soap.service;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-01T12:51:11.362+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebServiceClient(name = "MailService", 
                  wsdlLocation = "classpath:wsdl/Mail.wsdl",
                  targetNamespace = "http://www.mail.com")
public class MailService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.mail.com", "MailService");
    public final static QName MailServiceSoapBinding = new QName("http://www.mail.com", "MailServiceSoapBinding");
    static {
        URL url = MailService.class.getClassLoader().getResource("wsdl/Mail.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(MailService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/Mail.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public MailService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MailService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MailService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public MailService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public MailService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public MailService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns MailServicePortType
     */
    @WebEndpoint(name = "MailServiceSoapBinding")
    public MailServicePortType getMailServiceSoapBinding() {
        return super.getPort(MailServiceSoapBinding, MailServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MailServicePortType
     */
    @WebEndpoint(name = "MailServiceSoapBinding")
    public MailServicePortType getMailServiceSoapBinding(WebServiceFeature... features) {
        return super.getPort(MailServiceSoapBinding, MailServicePortType.class, features);
    }

}
