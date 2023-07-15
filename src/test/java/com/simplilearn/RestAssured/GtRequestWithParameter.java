package com.simplilearn.RestAssured;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;

public class GtRequestWithParameter {
	@Test
	public void test() {
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();

		System.out.println("rsponce body : " + response.getBody().asString());
		System.out.println("rsponce code : " + response.statusCode());
		System.out.println("rsponce header : " + response.getHeaders().asList());
		Assert.assertEquals(response.statusCode(), 200);

		String body = response.getBody().asString();

		System.out.println("Response body is " + body);
		
		JsonPath json = response.jsonPath();
		
		//Response response = request.get("/2");
		//Assert.assertTrue(body.contains("Pankaj"));
		//Integer id = json.getInt("id");
		//String name = json.get("name");
		//String salary = json.get("salary");
		// Assert.assertEquals(name, "Pankaj");
		//HashMap<String, String> basket = new HashMap<String, String>();
		//basket.put("id", id.toString());
		//basket.put("name", name);
		//basket.put("salary", salary);
		//System.out.println("The map is " + basket);
		
		List<String> names = json.get("name");
		for(String nam : names) {
			System.out.println("The Names Are : " + nam);
		}
	}
}
