package com.simplilearn.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFIle {
	@Test
	public void test() throws IOException {
		byte[] datafile = Files.readAllBytes(Paths.get("data.json"));
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(datafile)
				.post("/create");

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());

	}

}
