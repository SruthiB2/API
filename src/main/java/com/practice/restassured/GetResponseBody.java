package com.practice.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetResponseBody {
	@Test
	public void getResponseBodyTest() {
		RestAssured.baseURI = "http://64.227.160.186:8080/api/accounts";
		Response response = RestAssured.given().when().get();
		System.out.println(response.prettyPrint());
	}
}
