package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.lists.DecisionAppealList;
import tim21.PortalPoverenika.model.lists.RescriptList;
import tim21.PortalPoverenika.model.rescript.ResenjeRoot;
import tim21.PortalPoverenika.repository.RescriptRepository;
import tim21.PortalPoverenika.soap.client.RescriptClient;
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

	@Autowired
	RescriptClient rescriptClient;

	@Autowired
	private Environment env;

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

	public ResenjeRoot getOne(String ID) {
		XMLResource xmlResource = rescriptRepository.getOne(ID);

		if(xmlResource == null)
			return null;

		ResenjeRoot rescript = null;
		JAXBContext context = null;

		try {
			context = JAXBContext.newInstance(ResenjeRoot.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			rescript = (ResenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
		} catch (JAXBException | XMLDBException e) {
			return null;
		}

		return rescript;
	}

	public RescriptList getAllByAppealId(String appealId) throws XMLDBException, JAXBException {
		List<ResenjeRoot> rescripts = new ArrayList<>();

		ResourceSet resourceSet = null;
		resourceSet = rescriptRepository.getAllByAppealId(appealId);

		ResourceIterator resourceIterator = resourceSet.getIterator();

		while (resourceIterator.hasMoreResources()){
			XMLResource xmlResource = (XMLResource) resourceIterator.nextResource();

			if(xmlResource == null)
				return null;
			JAXBContext context = JAXBContext.newInstance(ZalbaRoot.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ResenjeRoot appeal = (ResenjeRoot) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
			rescripts.add(appeal);


		}
		return new RescriptList(rescripts);
	}

	public RescriptList getAllByUser(String email) throws XMLDBException, JAXBException {
		List<ResenjeRoot> rescripts = new ArrayList<>();

		ResourceSet resourceSet = null;
		resourceSet = rescriptRepository.getAllByUser(email);
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

	public boolean sendToOffical(ResenjeRoot rescript) {

		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("tim21.PortalPoverenika.model.rescript");

		rescriptClient.setDefaultUri(env.getProperty("portal_vlasti"));
		rescriptClient.setMarshaller(marshaller);

		Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
		unmarshaller.setContextPath("tim21.PortalPoverenika.soap.dto");
		rescriptClient.setUnmarshaller(unmarshaller);

		return rescriptClient.submitRescript(rescript.getResenje());
	}
}
