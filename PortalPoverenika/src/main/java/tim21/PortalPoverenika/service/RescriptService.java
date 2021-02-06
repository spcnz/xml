package tim21.PortalPoverenika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;
import tim21.PortalPoverenika.repository.RescriptRepository;
import tim21.PortalPoverenika.soap.client.RequestClient;
import tim21.PortalPoverenika.soap.client.RescriptClient;
import tim21.PortalPoverenika.util.Validator;
import tim21.PortalPoverenika.util.transformer.PDFTransformer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
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

	@Autowired
	private RequestClient requestClient;

	@Autowired
	private SilenceAppealService silenceAppealService;

	@Autowired
	private DecisionAppealService decisionAppealService;

	public static final String XSL_FILE = "src/main/resources/xsl/rescript.xsl";

	public static final String XSL_FO_FILE = "src/main/resources/xsl/rescript_fo.xsl";

	public boolean checkAppealId(String appealID) {

		ZalbaCutanjeRoot silenceAppeal = silenceAppealService.getOne(appealID);
		ZalbaRoot decisionAppeal = decisionAppealService.getOne(appealID);

		//apeal doesnt exist
		if (silenceAppeal == null && decisionAppeal == null) {
			return false;
		}

		String requestID;
		if (silenceAppeal != null) {
			try {
				requestID = silenceAppeal.getOtherAttributes().get(new QName("href")).split("/")[3];
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			try {
				requestID = decisionAppeal.getOtherAttributes().get(new QName("href")).split("/")[3];
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		//check request status, can not create rescript if request is approved
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("tim21.PortalPoverenika.soap.dto.request");
		requestClient.setDefaultUri(env.getProperty("portal_vlasti"));
		requestClient.setMarshaller(marshaller);
		requestClient.setUnmarshaller(marshaller);


		Boolean requestExists = requestClient.getRequest(requestID);

		System.out.println(requestExists);

		if (!requestExists) {
			return false;
		}

		//check request status
		String status = requestClient.getRequestStatus(requestID);
		System.out.println(status);
		if (status == null) {
			return false;
		}
		//rescript can be created only if request has been rejected or is in process
		if (status.equals("ACCEPTED")) {
			return false;
		}

		return true;
	}

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

	public String generatePdf(String ID) {
		XMLResource rescript = rescriptRepository.getOne(ID);
		PDFTransformer transformer = new PDFTransformer();

		if(rescript == null)
			return null;

		String pdfPath ="src/main/resources/static/rescript/rescript_" + ID + ".pdf";
		try {
			transformer.generatePDF(rescript.getContent().toString(), pdfPath, XSL_FO_FILE);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return pdfPath;
	}

	public String generateHtml(String ID) {
		XMLResource rescript = rescriptRepository.getOne(ID);
		PDFTransformer transformer = new PDFTransformer();

		if(rescript == null)
			return null;

		String htmlPath ="src/main/resources/static/rescript/rescript_" + ID + ".html";
		try {
			transformer.generateHTML(rescript.getContent().toString(), htmlPath, XSL_FILE);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return htmlPath;
	}
}
