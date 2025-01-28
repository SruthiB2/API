package api.restclient;

import io.restassured.response.Response;

public interface RestClient {
	public Response post(String requestPayload, String url);
	public Response get(String url);
	public Response get(String url, String pathParam, int pathParamValue);
}
