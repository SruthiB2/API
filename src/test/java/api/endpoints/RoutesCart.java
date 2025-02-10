package api.endpoints;

public class RoutesCart {
	
	public static String baseURL_Cart = "http://localhost:9001";
	public static String baseURL_Segment = "http://localhost:1080";
	
	public static String addOffer = baseURL_Cart+"/api/v1/offer";
	public static String applyOffer = baseURL_Cart+"/api/v1/cart/apply_offer";
	public static String getSegment = baseURL_Segment+"/api/v1/user_segment?user_id={id}";

}
