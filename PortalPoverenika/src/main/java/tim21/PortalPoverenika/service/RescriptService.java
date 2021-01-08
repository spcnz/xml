package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.Resenje;
import tim21.PortalPoverenika.repository.RescriptRepository;
import tim21.PortalPoverenika.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;


@Service
public class RescriptService {

	@Autowired
	RescriptRepository rescriptRepository;

	public boolean create(Resenje rescript) {
		if (Validator.validate(rescript.getClass(), rescript)){
			return rescriptRepository.create(rescript);
		}
		return false;
	}

	public RescriptList getAll() throws XMLDBException, JAXBException {
		List<Resenje> rescripts = new ArrayList<>();

		ResourceSet resourceSet = null;
		resourceSet = rescriptRepository.getAll();
		ResourceIterator resourceIterator = resourceSet.getIterator();

		while (resourceIterator.hasMoreResources()){
			XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
			System.out.println(xmlResource);
			if(xmlResource == null)
				return null;
			JAXBContext context = JAXBContext.newInstance(Resenje.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Resenje rescript = (Resenje) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
			rescripts.add(rescript);
		}
		return new RescriptList(rescripts);
	}

	public Resenje getOne(String ID) {
		XMLResource xmlResource = rescriptRepository.getOne(ID);

		if(xmlResource == null)
			return null;

		Resenje rescript = null;
		JAXBContext context = null;

		try {
			context = JAXBContext.newInstance(Resenje.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			rescript = (Resenje) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
		} catch (JAXBException | XMLDBException e) {
			return null;
		}

		return rescript;
	}
}
