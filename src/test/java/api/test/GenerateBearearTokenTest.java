package api.test;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenerateBearearTokenTest {

	static String tokenVal;
	@Test
	public static void generatBearerToken(ITestContext context) {

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
		 context.setAttribute("bearerToken", tokenVal);
	//return tokenVal;
	}
}
