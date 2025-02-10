package api.endpoints;

import java.io.IOException;

import api.helper.JsonHelper;
import api.payload.ApplyOfferRequest;
import api.restclient.RestClient;
import api.restclient.RestClientImpl;
import io.restassured.response.Response;

public class ApplyOfferEndpoints {
	JsonHelper jsonHelper = new JsonHelper();
	RestClient restClient = new RestClientImpl();

	public Response applyOfferToCart(ApplyOfferRequest applyOfferReq) throws IOException {
		ApplyOfferRequest applyOfferRequest = new ApplyOfferRequest(applyOfferReq.getCart_value(),
				applyOfferReq.getUser_id(), applyOfferReq.getRestaurant_id());
		String applyOfferJsonRequest = jsonHelper.BusinessObjectToJson(applyOfferRequest);
		return restClient.post(applyOfferJsonRequest, RoutesCart.applyOffer);
	}
}
