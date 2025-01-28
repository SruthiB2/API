package api.endpoints;
import api.endpoints.Routes;
import api.utility.TokenGenerationUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserManagementEndpoints {

	
	public Response getUserProfileDetails(String token) {
		//String token = TokenGenerationUtility.generatBearerToken();
		Response getprofileDetails = RestAssured.given().
				header("Authorization","Bearer "+token).
				when().
				get(Routes.getProfileDetailsEndpoint);
		return getprofileDetails;
	}
}
