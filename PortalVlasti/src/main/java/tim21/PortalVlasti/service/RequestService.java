package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.request.ZahtevRoot;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.repository.RequestRepository;
import tim21.PortalVlasti.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;


    public ZahtevRoot create(ZahtevRoot request, String submitterId) throws IOException, SAXException {


        if (Validator.validate(request.getClass(), request)){

            return requestRepository.create(request, submitterId);
        }
        return null;
    }


    public RequestList getAll() throws XMLDBException, JAXBException {
        List<ZahtevRoot> requests = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = requestRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevRoot request = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            requests.add(request);
        }

        return new RequestList(requests);
    }

    public ZahtevRoot getOne(String ID) {
        XMLResource xmlResource = requestRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ZahtevRoot request = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ZahtevRoot.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            request = (ZahtevRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return request;
    }

    public boolean rejectRequest(String id) {
        ZahtevRoot request = getOne(id);
        if (request == null) {
            return false;
        }

        try {
            requestRepository.reject(request);

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

    }
}
