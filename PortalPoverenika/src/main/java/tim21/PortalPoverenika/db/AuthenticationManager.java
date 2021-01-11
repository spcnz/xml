package tim21.PortalPoverenika.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class AuthenticationManager {
	
	@Value("${conn.user}")
	private String user;
	@Value("${conn.password}")
	private String password;
	@Value("${conn.host}")
	private String host;
	@Value("${conn.port}")
	private String port;
	@Value("${conn.driver}")
	private String driver;
	@Value("${conn.uri}")
	private String uri;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}



	static public class ConnectionProperties {

		public String endpoint;
		public String dataset;

		public String queryEndpoint;
		public String updateEndpoint;
		public String dataEndpoint;


		public ConnectionProperties(Properties props) {
			super();
			dataset = props.getProperty("conn.dataset").trim();
			endpoint = props.getProperty("conn.endpoint").trim();

			queryEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.query").trim());
			updateEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.update").trim());
			dataEndpoint = String.join("/", endpoint, dataset, props.getProperty("conn.data").trim());

			System.out.println("[INFO] Parsing connection properties:");
			System.out.println("[INFO] Query endpoint: " + queryEndpoint);
			System.out.println("[INFO] Update endpoint: " + updateEndpoint);
			System.out.println("[INFO] Graph store endpoint: " + dataEndpoint);
		}
	}

	/**
	 * Read the configuration properties for the example.
	 *
	 * @return the configuration object
	 */
	public static ConnectionProperties loadProperties() throws IOException {
		String propsName = "application.properties";

		InputStream propsStream = openStream(propsName);
		if (propsStream == null)
			throw new IOException("Could not read properties " + propsName);

		Properties props = new Properties();
		props.load(propsStream);

		return new ConnectionProperties(props);
	}

	/**
	 * Read a resource for an example.
	 *
	 * @param fileName
	 *            the name of the resource
	 * @return an input stream for the resource
	 * @throws IOException
	 */
	public static InputStream openStream(String fileName) throws IOException {
		return AuthenticationManager.class.getClassLoader().getResourceAsStream(fileName);
	}
}
