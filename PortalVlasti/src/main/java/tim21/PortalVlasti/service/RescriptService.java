package tim21.PortalVlasti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalVlasti.model.lists.RescriptList;
import tim21.PortalVlasti.soap.dto.rescript.ResenjeRoot;
import tim21.PortalVlasti.repository.RescriptRepository;
import tim21.PortalVlasti.util.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class RescriptService {

	@Autowired
	RescriptRepository rescriptRepository;

	public ResenjeRoot create(ResenjeRoot rescript) {


		if (Validator.validate(rescript.getClass(), rescript)){

			return rescriptRepository.create(rescript);
		}
		return null;
	}

	public RescriptList getAll() throws XMLDBException, JAXBException {
		List<ResenjeRoot> rescripts = new ArrayList<>();

		ResourceSet resourceSet = null;
		resourceSet = rescriptRepository.getAll();
		ResourceIterator resourceIterator = resourceSet.getIterator();

		while (resourceIterator.hasMoreResources()){
			XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();
			System.out.println(xmlResource);
			if(xmlResource == null)
				return null;
			JAXBContext context = JAXBContext.newInstance(ResenjeRoot.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ResenjeRoot rescript = (ResenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
			rescripts.add(rescript);
		}
		return new RescriptList(rescripts);
	}


	public RescriptList search(String keyword) throws XMLDBException, JAXBException {
		List<ResenjeRoot> rescripts = new ArrayList<>();

		ResourceSet resourceSet = null;
		resourceSet = rescriptRepository.search(keyword);

		ResourceIterator resourceIterator = resourceSet.getIterator();

		while (resourceIterator.hasMoreResources()) {
			XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();

			System.out.println(xmlResource);
			if (xmlResource == null)
				return null;
			JAXBContext context = JAXBContext.newInstance(ResenjeRoot.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ResenjeRoot rescript = (ResenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
			rescripts.add(rescript);
		}
		return new RescriptList(rescripts);
	}
}
