package api.test;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import api.endpoints.TweetEndpoints;
import api.payload.TweetRequest;
import api.payload.TweetResponse;
import io.restassured.response.Response;

public class TestUpdateTweetEndpoint {	
	Response response;
	TweetResponse tweetResponse;
	TweetEndpoints tweetEndpoints = new TweetEndpoints();
	int userId,id;
	String title,body;
	TestCreateTweetEndpoint obj = new TestCreateTweetEndpoint();
	TweetResponse tResp ;
	
	
	@BeforeMethod
	public void beforeMethodSetUp(ITestContext context) {
		
		  userId = (Integer) context.getAttribute("user_id"); title = (String)
		  context.getAttribute("title"); body = (String) context.getAttribute("body");
		  id = (Integer)context.getAttribute("id");
		 
		System.out.println("idddddddddddddd2: "+userId);
		 tResp = (TweetResponse) context.getAttribute("resp");
		
	}

	@Test//(dataProvider = "tweetTestData", dataProviderClass = TestTweetEndpoint.class)
	public void updateTweet() {
		TweetRequest tweet = new TweetRequest();		
		
		  tweet.setTitle("new title"); 
		  
		  //tweet.setUserId(4.0); tweet.setBody("new body");
		 
	System.out.println("idddddddddddddd: "+userId);
	 response	 = tweetEndpoints.updateTweet((int) tweet.getUserId(), tweet);
		Gson gson = new Gson();
		tweetResponse = gson.fromJson(response.getBody().asString(), TweetResponse.class);
		Assert.assertEquals(tweetResponse.getTitle(),"new title");
	}
	
}
