package SpringBootApplication;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployee {
	@Test
	public void test() {
		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();

		Response response = request.get();
		// System.out.println("toString : " + response.getBody().toString());

		System.out.println("rsponce body : " + response.getBody().asString());
		System.out.println("rsponce code : " + response.statusCode());
		System.out.println("rsponce header : " + response.getHeaders().asList());
		Assert.assertEquals(response.statusCode(), 200);
		// Print all the names of employees on the console
		JsonPath json = response.jsonPath();
		List<String> names = json.get("firstName");

		for (String name : names) {

			System.out.println("The name is " + name);

		}
	}

}
