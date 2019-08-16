package pe.com.claro.venta.usuariobiometria.restclient;

import pe.com.claro.venta.usuariobiometria.restclient.RestClient.RestClientBuilder;

public class AbstractRestClient {

    protected RestClient restClient;

    protected void loadRestClient(String url, int connectionTimeout) {
	restClient = new RestClientBuilder(url).connectionTimeoutBuilder(connectionTimeout).build();
    }

    public RestClient getRestClient() {
	return restClient;
    }

}
