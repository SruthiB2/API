package api.helper;

import com.google.gson.Gson;

import api.payload.ApplyOfferRequest;
import api.payload.ApplyOfferResponse;
import io.restassured.response.Response;

public class JsonHelper {
	
	public String BusinessObjectToJson(ApplyOfferRequest applyOfferRequest) {
		Gson gson = new Gson();
		String tweetJsonString = gson.toJson(applyOfferRequest);
		return tweetJsonString;
	}

	public ApplyOfferResponse JsonToBusinessObject(Response response) {
		ApplyOfferResponse applyOfferResponse = new ApplyOfferResponse();
		Gson gson = new Gson();
		applyOfferResponse = gson.fromJson(response.getBody().asString(), ApplyOfferResponse.class);
		return applyOfferResponse;
	}

}
