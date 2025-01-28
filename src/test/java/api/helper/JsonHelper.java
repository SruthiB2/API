package api.helper;

import com.google.gson.Gson;

import api.payload.TweetRequest;
import api.payload.TweetResponse;
import io.restassured.response.Response;

public class JsonHelper {

	public String JsonToBusinessObject(TweetRequest tweetRequest) {
		Gson gson = new Gson();
		String tweetJsonString = gson.toJson(tweetRequest);
		return tweetJsonString;
	}

	public TweetResponse BusinessObjectToJson(Response response) {
		TweetResponse tweetResponse = new TweetResponse();
		Gson gson = new Gson();
		tweetResponse = gson.fromJson(response.getBody().asString(), TweetResponse.class);
		return tweetResponse;
	}

}
