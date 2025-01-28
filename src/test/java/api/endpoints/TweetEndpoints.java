package api.endpoints;

import java.io.IOException;

import api.helper.JsonHelper;
import api.payload.TweetRequest;
import api.restclient.RestClient;
import api.restclient.RestClientImpl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TweetEndpoints {
	 JsonHelper jsonHelper = new JsonHelper();
	 RestClient restClient = new RestClientImpl();
	 
	public Response createTweet(TweetRequest tweet) throws IOException {
		TweetRequest tweetRequest = new TweetRequest(tweet.getTitle(), tweet.getBody(), tweet.getUserId());
		String tweetJsonString = jsonHelper.JsonToBusinessObject(tweetRequest);
		return restClient.post(tweetJsonString, Routes.createOrGetAllTweetEndpoint);
	}

	 public Response readAllTweets() {
		 Response readAllTweetResponse = restClient.get(Routes.createOrGetAllTweetEndpoint);
		 return readAllTweetResponse;
	 }
	 
	 public Response readATweet(int idVal) {
		 Response readASpecificTweetResponse = restClient.get(Routes.fetchOrUpdateOrPatchOrDeleteTweetEndpoint, "id", idVal);
		 return readASpecificTweetResponse;
	 }
	 
	 public Response updateTweet(int id, TweetRequest tweetPayload) {
		 Response updateTweetResponse = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON)
				 .pathParam("id", id).body(tweetPayload)
				 .when().put(Routes.fetchOrUpdateOrPatchOrDeleteTweetEndpoint);
		 return updateTweetResponse;
	 }
	 
	 public static Response deleteATweet(int id) {
		 Response deleteATweetResponse = RestAssured.given().pathParam("id", id)
				 .when().delete(Routes.fetchOrUpdateOrPatchOrDeleteTweetEndpoint);
		 return deleteATweetResponse;
	 }
	
}
