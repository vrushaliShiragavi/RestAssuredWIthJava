package restAPIBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequestBDD {
	@Test
	public void test() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.delete("/3")
		.then()
		.statusCode(200)
		.log()
		.body();	
	}

}
