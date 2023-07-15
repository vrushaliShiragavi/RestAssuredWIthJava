package restAPIBDD;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestBDD {
	@Test
	public void Test1() {

		JSONObject jobj = new JSONObject();
		//jobj.put("name", "Priya");
		jobj.put("salary", "9000");
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jobj.toString())
		.when()
		.put("/5")
		.then()
		.statusCode(200)
		.log()
		.body();		
	}


}
