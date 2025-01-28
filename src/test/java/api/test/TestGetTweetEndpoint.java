package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import api.endpoints.TweetEndpoints;
import api.payload.GetAllTweetsResponse;
import api.payload.TweetResponse;
import io.restassured.response.Response;

public class TestGetTweetEndpoint {
	TweetEndpoints tweetEndpoints = new TweetEndpoints();
	Response response;
	TweetResponse tweetResponse;

	@Test
	public void testGetATweetDetails(ITestContext context) {
		int id = (Integer) context.getAttribute("user_id");
		response = tweetEndpoints.readATweet(id);
		Gson gson = new Gson();
		tweetResponse = gson.fromJson(response.getBody().asString(), TweetResponse.class);
		Assert.assertEquals(tweetResponse.getId(), id);
		Assert.assertTrue(tweetResponse.getTitle().contains("sunt aut facere repellat provident"));
	}

	@Test
	public void testGetAllTweets() {
		Response response = tweetEndpoints.readAllTweets();
		Gson gson = new Gson();
		GetAllTweetsResponse[] tweetResponse = gson.fromJson(response.getBody().asString(),
				GetAllTweetsResponse[].class);
		Assert.assertTrue(tweetResponse.length != 0);
	}

}
