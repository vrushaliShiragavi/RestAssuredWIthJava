package com.simplilearn.RestAssured;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWIthMap {

	@Test
	public void test() {
		HashMap<String, Object> basket = new HashMap<String, Object>();
		basket.put("name", "Rohan");
		basket.put("salary", "1000");
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(basket.toString()).post("/create");

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());

	}
}