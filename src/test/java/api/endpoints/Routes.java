package api.endpoints;


//All URLs will be maintained here
public class Routes {

	
	public static String baseURL = "https://jsonplaceholder.typicode.com/";
	
	public static String createOrGetAllTweetEndpoint = baseURL+"posts/";
	public static String fetchOrUpdateOrPatchOrDeleteTweetEndpoint = createOrGetAllTweetEndpoint+"{id}";
	
	//Banking app endpoints
	
	public static String bankingBaseURL = "http://64.227.160.186:8080";
	public static String getProfileDetailsEndpoint = bankingBaseURL+"/api/users/profile";
	public static String loginAuthEndpoint = bankingBaseURL+"/api/auth/login";
	public static String changePasswordEndpoint = bankingBaseURL+"/api/users/change-password";
	
	
}
