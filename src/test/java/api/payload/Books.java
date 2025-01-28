package api.payload;

import java.util.List;

public class Books {
	
	/*
	 *  {
           "category" : "fiction",
           "bookName": "fiction book1",
           "author": "james",
           "price": 20,
           "isbn": "isbn1",
           "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888",
            "info": "ph1"
        }
	 */
	
	
	private String category;
	private String bookName;
	private String author;
	private String price;
	private String isbn;
	private List<PhoneNumbers> phoneNumbers;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
	
	
	
	

}
