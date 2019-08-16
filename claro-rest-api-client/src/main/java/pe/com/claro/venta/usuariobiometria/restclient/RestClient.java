package pe.com.claro.venta.usuariobiometria.restclient;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.internal.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.venta.usuariobiometria.restclient.entity.AuthenticationMode;
import pe.com.claro.venta.usuariobiometria.restclient.entity.AuthenticationToken;
import pe.com.claro.venta.usuariobiometria.restclient.exception.ErrorResponse;

public final class RestClient {

    private static final Logger LOG = LoggerFactory.getLogger(RestClient.class);

    private String baseURI;
    private AuthenticationToken token;
    private String password;
    private int connectionTimeout;
    private MultivaluedMap<String, Object> headers;

    public <T> T get(String restPath, Class<T> expectedResponse, Map<String, String> queryParams) {
	return call(HttpMethod.GET, restPath, expectedResponse, null, queryParams);
    }

    public Response post(String restPath, Object payload, Map<String, String> queryParams) {
	LOG.debug("POST: {}", restPath);
	return call(HttpMethod.POST, restPath, Response.class, payload, queryParams);
    }

    public Response put(String restPath, Object payload, Map<String, String> queryParams) {
	LOG.debug("PUT: {}", restPath);
	return call(HttpMethod.PUT, restPath, Response.class, payload, queryParams);
    }

    public Response delete(String restPath, Map<String, String> queryParams) {
	LOG.debug("DELETE: {}", restPath);
	return call(HttpMethod.DELETE, restPath, Response.class, null, queryParams);
    }

    @SuppressWarnings("unchecked")
    public <T> T call(String methodName, String restPath, Class<T> expectedResponse, Object payload, Map<String, String> queryParams) {
	WebTarget webTarget = createWebTarget(restPath, queryParams);

	Response result = webTarget.request().headers(headers).method(methodName, Entity.entity(payload, MediaType.APPLICATION_JSON), Response.class);

	if (expectedResponse.getName().equals(Response.class.getName())) {
	    return (T) result;
	}

	if (result != null && result.hasEntity() && isStatusCodeOK(result, restPath)) {
	    return (T) result.readEntity(expectedResponse);
	}

	return null;
    }

    private boolean isStatusCodeOK(Response response, String uri) {
	if (response.getStatus() == Status.OK.getStatusCode() || response.getStatus() == Status.CREATED.getStatusCode()) {
	    return true;
	}
	else if (response.getStatus() == Status.UNAUTHORIZED.getStatusCode()) {
	    LOG.error("UNAUTHORIZED: Your credentials are wrong. Please check your username/password or the secret key");
	}
	else if (response.getStatus() == Status.CONFLICT.getStatusCode() || response.getStatus() == Status.NOT_FOUND.getStatusCode() || response.getStatus() == Status.FORBIDDEN.getStatusCode() || response.getStatus() == Status.BAD_REQUEST.getStatusCode()) {
	    ErrorResponse errorResponse = response.readEntity(ErrorResponse.class);
	    LOG.error("{} - {} on ressource {}", errorResponse.getException(), errorResponse.getMessage() + " :::: " + errorResponse.getRessource());
	}
	else {
	    LOG.error("Unsupported status code: " + response);
	}
	LOG.error(response.toString());

	return false;
    }

    private WebTarget createWebTarget(String restPath, Map<String, String> queryParams) {
	WebTarget webTarget;
	try {
	    URI u = new URI(this.baseURI + restPath);
	    Client client = createrRestClient();

	    webTarget = client.target(u);
	    if (queryParams != null && !queryParams.isEmpty()) {
		for (Map.Entry<String, String> entry : queryParams.entrySet()) {
		    if (entry.getKey() != null && entry.getValue() != null) {
			LOG.debug("PARAM: {} = {}", entry.getKey(), entry.getValue());
			webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
		    }
		}
	    }

	}
	catch (Exception e) {
	    LOG.error("Error", e);
	    return null;
	}

	return webTarget;
    }

    public RestClient(RestClientBuilder builder) {
	this.baseURI = builder.baseURI;
	this.connectionTimeout = builder.connectionTimeout;
	this.setHeaders(builder.headers);
	this.token = builder.token;
    }

    private Client createrRestClient() throws KeyManagementException, NoSuchAlgorithmException {
	ClientConfig clientConfig = new ClientConfig();

	if (this.connectionTimeout != 0) {
	    clientConfig.property(ClientProperties.CONNECT_TIMEOUT, this.connectionTimeout);
	    clientConfig.property(ClientProperties.READ_TIMEOUT, this.connectionTimeout);
	}

	clientConfig.register(new LoggingFilter());

	Client client = null;
	if (this.baseURI.startsWith("https")) {
	    client = createSLLClient(clientConfig);
	}
	else {
	    client = ClientBuilder.newClient(clientConfig);
	}

	return client;
    }

    private Client createSLLClient(ClientConfig clientConfig) throws KeyManagementException, NoSuchAlgorithmException {
	TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	    public X509Certificate[] getAcceptedIssuers() {
		return new X509Certificate[0];
	    }

	    public void checkClientTrusted(X509Certificate[] certs, String authType) {
		this.toString();
	    }

	    public void checkServerTrusted(X509Certificate[] certs, String authType) {
		this.toString();
	    }
	} };

	SSLContext sc = SSLContext.getInstance("TLS");
	sc.init(null, trustAllCerts, new SecureRandom());
	HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

	ClientBuilder.newClient(clientConfig);

	Client client = ClientBuilder.newBuilder().sslContext(sc).hostnameVerifier(new HostnameVerifier() {
	    public boolean verify(String s, SSLSession sslSession) {
		return true;
	    }
	}).withConfig(clientConfig).build();

	return client;
    }

    public static class RestClientBuilder {

	private String baseURI;
	private int connectionTimeout;
	private MultivaluedMap<String, Object> headers;
	private AuthenticationToken token;

	public RestClientBuilder(String baseUri) {
	    this.headers = new MultivaluedHashMap<String, Object>();
	    this.baseURI = baseUri;
	}

	public RestClientBuilder connectionTimeoutBuilder(int connectionTimeout) {
	    this.connectionTimeout = connectionTimeout;
	    return this;
	}

	public RestClientBuilder authenticationToken(AuthenticationToken token) {
	    if (token.getAuthMode() == AuthenticationMode.SHARED_SECRET_KEY) {
		headers.add(HttpHeaders.AUTHORIZATION, token.getSharedSecretKey());
	    }
	    else if (token.getAuthMode() == AuthenticationMode.BASIC_AUTH) {
		String base64 = Base64.encodeAsString(token.getUsername() + ":" + token.getPassword());
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + base64);
	    }

	    this.token = token;
	    return this;
	}

	public RestClientBuilder headersBuilder(MultivaluedMap<String, Object> headers) {
	    this.headers = headers;
	    return this;
	}

	public RestClient build() {
	    return new RestClient(this);
	}
    }

    public String getUri() {
	return baseURI;
    }

    public void setUri(String uri) {
	this.baseURI = uri;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getConnectionTimeout() {
	return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
	this.connectionTimeout = connectionTimeout;
    }

    public AuthenticationToken getToken() {
	return token;
    }

    public void setToken(AuthenticationToken token) {
	this.token = token;
    }

    public MultivaluedMap<String, Object> getHeaders() {
	return headers;
    }

    public void setHeaders(MultivaluedMap<String, Object> headers) {
	this.headers = headers;
    }
}