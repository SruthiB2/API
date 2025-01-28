package api.endpoints;

import api.utility.TokenGenerationUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ChangePasswordEndpoint {
	
	public Response getUserProfileDetails() {
		String token = TokenGenerationUtility.generatBearerToken();
		Response changePasswordResponse = RestAssured.given().
				header("Authorization","Bearer "+token).
				when().
				get(Routes.changePasswordEndpoint);
		return changePasswordResponse;
	}

}
