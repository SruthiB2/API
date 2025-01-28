package api.payload;

public class PhoneNumbers {
	
	/*
	 * "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888",
            "info": "ph1"
        }
	 * 
	 */
	
	private String type;
	private String number;
	private String info;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	
	
}
