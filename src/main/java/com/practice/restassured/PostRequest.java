package com.practice.restassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	
	@Test
	public void testMethod() {
		RestAssured.baseURI = "http://64.227.160.186:8080/api/accounts";
		RestAssured.given()
	     .pathParam("id", 1)
	 .when()
	     .get("/users/{id}")
	 .then()
	     .statusCode(200);
	   //  .body("name", notNullValue());
		
		//RestAssured.given().accept(ContentType.JSON).headers(null)
	}
	
	
}
