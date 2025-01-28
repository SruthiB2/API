package api.restclient;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClientImpl implements RestClient{

	public Response post(String requestPayload, String url) {

		return RestAssured.given().contentType("application/json").accept(ContentType.JSON)
				.body(requestPayload).when().post(url);
	}
	public Response get(String url) {
		return RestAssured.given().when().get(url);
		
	}
	public Response get(String url, String pathParam, int pathParamValue) {
		return RestAssured.given().pathParam(pathParam, pathParamValue)
				 .when().get(url);
	}
	
}
