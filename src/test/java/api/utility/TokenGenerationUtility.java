package api.utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenGenerationUtility {
	static String tokenVal;
	public static String generatBearerToken() {

		RestAssured.baseURI = Routes.bankingBaseURL;
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.header("Content-Type", "application/json");
		String reqPayload = "{\r\n"
				+ "  \"username\": \"sruthi.b241@gmail.com\",\r\n"
				+ "  \"password\": \"Banking@123\"\r\n"
				+ "}";
		Response resp = requestSpecification.body(reqPayload).post(Routes.loginAuthEndpoint);
		String respStr = resp.asString();
	JsonObject jsonObject =	JsonParser.parseString(respStr).getAsJsonObject();
		 tokenVal = jsonObject.get("token").getAsString();
		 System.out.println("token value: "+tokenVal);
	return tokenVal;
	}

}
