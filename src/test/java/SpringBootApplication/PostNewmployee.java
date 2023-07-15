package SpringBootApplication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewmployee {
	@Test
	public void test() {

		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "\"firstName\": \"Vidhya\",\r\n"
						+ "\"lastName\": \"Vidhya\",\r\n"
						+ "\"salary\": \"9000\"\r\n"
						+ "\"email\": \"Vidhya\",\r\n"
						+ "}")
				.post("/create");

		String body = response.getBody().asString();
		System.out.println("Response body is " + body);

		System.out.println("Response code is " + response.statusCode());

	}

}
