package api.test;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import api.endpoints.Routes;
import api.endpoints.UserManagementEndpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserManagementTest {
	String tokenVal;
	UserManagementEndpoints userManagementEndpoints = new UserManagementEndpoints() ;
	@Test
	public void testGetUserProfileDetails(ITestContext context) {
		RestAssured.baseURI = Routes.bankingBaseURL;
		Response resp = userManagementEndpoints.getUserProfileDetails((String) context.getAttribute("bearerToken"));
		String respStr = resp.asString();
		JsonObject jsonObject =	JsonParser.parseString(respStr).getAsJsonObject();
		System.out.println(jsonObject.get("id").getAsString());
		String id = jsonObject.get("id").getAsString();
		//context.setAttribute("id", id);
	}
	
}
