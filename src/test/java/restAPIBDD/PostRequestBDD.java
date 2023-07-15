package restAPIBDD;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestBDD {
	@Test
	public void Test1() {

		JSONObject jobj = new JSONObject();
		jobj.put("name", "Priya");
		jobj.put("salary", "6500");
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jobj.toString())
		.when()
		.post("/create")
		.then()
		.statusCode(201)
		.log()
		.body();		
	}

}
