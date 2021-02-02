
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tim21.PortalPoverenika.soap.service.decisionAppeal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tim21.PortalPoverenika.model.decisionAppeal.TZalba;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.service.DecisionAppealService;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2021-02-02T01:56:59.887+01:00
 * Generated source version: 3.2.1
 * 
 */

@WebService(
                      serviceName = "DecisionAppealService",
                      portName = "DecisionAppealServiceSoapBinding",
                      targetNamespace = "http://www.zalbanaodluku.com",
                      wsdlLocation = "classpath:wsdl/DecisionAppeal.wsdl",
                      endpointInterface = "tim21.PortalPoverenika.soap.service.decisionAppeal.DecisionAppealServicePortType")
@Service
public class DecisionAppealServiceSoapBindingImpl implements DecisionAppealServicePortType {

    private static final Logger LOG = Logger.getLogger(DecisionAppealServiceSoapBindingImpl.class.getName());

    @Autowired
    DecisionAppealService decisionAppealService;
    /* (non-Javadoc)
     * @see com.zalbanaodluku.DecisionAppealServicePortType#getDecisionAppealById(java.lang.String id)*
     */
    public TZalba getDecisionAppealById(String id) {
        LOG.info("Executing operation getDecisionAppealById");
        System.out.println(id);
        try {
            ZalbaRoot rootEl = decisionAppealService.getOne(id);
            return rootEl.getZalba();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.zalbanaodluku.DecisionAppealServicePortType#getAll()*
     */
    public DecisionAppealList getAll() {
        LOG.info("Executing operation getAll");
        try {
            DecisionAppealList _return = decisionAppealService.getAll();
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}