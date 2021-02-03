package tim21.PortalPoverenika.db;

import org.exist.xmldb.EXistResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;
import tim21.PortalPoverenika.service.MetaDataService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

@Service
public class ExistManager {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private MetaDataService metadataExtract;

	public void createConnection() throws Exception {
		Class<?> cl = Class.forName(authManager.getDriver());
		// encapsulation of the database driver functionality
		Database database = (Database) cl.newInstance();
		database.setProperty("create-database", "true");

		// entry point for the API which enables you to get the Collection reference
		DatabaseManager.registerDatabase(database);
	}

	public void closeConnection(Collection col, XMLResource res) throws XMLDBException {
		if (col != null) {
			col.close();
		}
		if (res != null) {
			((EXistResource) res).freeResources();
		}
	}

	public Collection getOrCreateCollection(String collectionUri, int pathOffset) throws XMLDBException {
		Collection col = DatabaseManager.getCollection(authManager.getUri()+collectionUri, authManager.getUser(), authManager.getPassword());
		if (col == null) {
			if (collectionUri.startsWith("/")) {
				collectionUri = collectionUri.substring(1);
			}
			String pathSegments[] = collectionUri.split("/");
			if (pathSegments.length > 0) {
				StringBuilder path = new StringBuilder();
				for (int i = 0; i <= pathOffset; i++) {
					path.append("/"+pathSegments[i]);
				}
				Collection startCol = DatabaseManager.getCollection(authManager.getUri() + path, authManager.getUser(),
						authManager.getPassword());
				if (startCol == null) {
					String parentPath = path.substring(0, path.lastIndexOf("/"));
					Collection parentCol = DatabaseManager.getCollection(authManager.getUri() + parentPath,
							authManager.getUser(), authManager.getPassword());
					CollectionManagementService service = (CollectionManagementService) parentCol
							.getService("CollectionManagementService", "1.0");
					col = service.createCollection(pathSegments[pathOffset]);
					col.close();
					parentCol.close();
				} else {
					startCol.close();
				}
			}
			return getOrCreateCollection(collectionUri, ++pathOffset);
		} else {
			return col;
		}
	}

	public boolean store(String collectionId, String documentId, Object xml, String collectionName) throws Exception {
		createConnection();
		Collection col = null;
		XMLResource res = null;
		OutputStream os = new ByteArrayOutputStream();
		boolean success = true;

		try {
			col = getOrCreateCollection(collectionId, 0);
			res = (XMLResource) col.createResource(documentId + ".xml", XMLResource.RESOURCE_TYPE);


			JAXBContext context = JAXBContext.newInstance(xml.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
					" <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
					"<?xml-stylesheet type=\"text/xsl\" href=\"../xsl/grddl.xsl\"?>");


			marshaller.marshal(xml, os);


			res.setContent(os);
			col.storeResource(res);

			// Ovdje ekstrahujemo
			metadataExtract.extract(os, collectionName, documentId);


		} catch (Exception e) {
			e.printStackTrace();
			success = false;
		} finally {
			try {
				closeConnection(col, res);
				return success;
			} catch (XMLDBException xe) {
				xe.printStackTrace();
			}
		}
		return success;
	}

	public XMLResource getOne(String collectionUri, String documentId) throws Exception  {
		createConnection();
		Collection col = null;
		XMLResource res = null;

		try {
			col = DatabaseManager.getCollection(authManager.getUri() + collectionUri, authManager.getUser(),
					authManager.getPassword());
			col.setProperty(OutputKeys.INDENT, "yes");
			res = (XMLResource) col.getResource(documentId + ".xml");
			return res;
		} finally {
			if (col != null) {
				col.close();
				res = null;
				col = null;
			}
		}
	}

	public ResourceSet getAll(String collectionUri, String xpathExp, String targetNamespace) throws Exception  {
		createConnection();
		Collection col = null;
		ResourceSet result = null;
		try {
			col = DatabaseManager.getCollection(authManager.getUri() + collectionUri, authManager.getUser(),
					authManager.getPassword());
			XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
			xpathService.setProperty("indent", "yes");
			xpathService.setNamespace("", targetNamespace);
			result = xpathService.query(xpathExp);
		} finally {
			if (col != null) {
				col.close();
				col = null;
			}
		}
		return result;
	}

	public ResourceSet search(String collectionUri, String keyword, String targetNamespace, String rootElement) throws Exception  {
		createConnection();
		Collection col = null;
		ResourceSet result = null;
		try {
			col = DatabaseManager.getCollection(authManager.getUri() + collectionUri, authManager.getUser(),
					authManager.getPassword());
			XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
			xpathService.setProperty("indent", "yes");
			xpathService.setNamespace("", targetNamespace);
			String xPathSelector = String.format("//%1$s[*//*[contains(text(),'%2$s')]] | //%1$s[*[contains(text(),'%2$s')]]", rootElement, keyword);
			result = xpathService.query(xPathSelector);
		} finally {
			if (col != null) {
				col.close();
				col = null;
			}
		}
		return result;
	}

}
