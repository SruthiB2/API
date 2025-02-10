package api.payload;

public class ApplyOfferRequest {

	private int cart_value;
	private int user_id;
	private int restaurant_id;
	
	public int getCart_value() {
		return cart_value;
	}
	public void setCart_value(int cart_value) {
		this.cart_value = cart_value;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public ApplyOfferRequest(int cart_value, int user_id, int restaurant_id) {
		super();
		this.cart_value = cart_value;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
	}
	
	
	
}
