package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.request.ZahtevDokument;
import tim21.PortalVlasti.model.lists.RequestList;
import tim21.PortalVlasti.repository.InformationRepository;
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


    public boolean create(ZahtevDokument request) throws IOException, SAXException {


        if (Validator.validate(request.getClass(), request)){

            return requestRepository.create(request);
        }
        return false;
    }


    public RequestList getAll() throws XMLDBException, JAXBException {
        List<ZahtevDokument> requests = new ArrayList<>();

        ResourceSet resourceSet = null;
        resourceSet = requestRepository.getAll();
        ResourceIterator resourceIterator = resourceSet.getIterator();

        while (resourceIterator.hasMoreResources()){
            XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
            System.out.println(xmlResource);
            if(xmlResource == null)
                return null;
            JAXBContext context = JAXBContext.newInstance(ZahtevDokument.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ZahtevDokument request = (ZahtevDokument) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
            requests.add(request);
        }

        return new RequestList(requests);
    }

    public ZahtevDokument getOne(String ID) {
        XMLResource xmlResource = requestRepository.getOne(ID);

        if(xmlResource == null)
            return null;

        ZahtevDokument request = null;
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(ZahtevDokument.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            request = (ZahtevDokument) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
        } catch (JAXBException | XMLDBException e) {
            return null;
        }

        return request;
    }
}
