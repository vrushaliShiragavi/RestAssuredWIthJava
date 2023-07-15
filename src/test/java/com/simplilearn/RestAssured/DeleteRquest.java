package com.simplilearn.RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRquest {
	@Test
	public void test() {

		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.delete("/6");

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());
	}

}
