package com.simplilearn.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test() {
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get();
		//System.out.println("toString : " + response.getBody().toString());

		System.out.println("rsponce body : " + response.getBody().asString());
		System.out.println("rsponce code : " + response.statusCode());
		System.out.println("rsponce header : " + response.getHeaders().asList());
		Assert.assertEquals(response.statusCode(), 200);
	}

}
