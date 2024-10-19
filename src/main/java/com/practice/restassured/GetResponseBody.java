package com.practice.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetResponseBody {
	@Test
	public void getResponseBodyTest() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification requestSpecification = RestAssured.given();
		Response resp = requestSpecification.request(Method.GET,"");
		System.out.println("Response: "+resp.prettyPrint());
	
	}
	

}
