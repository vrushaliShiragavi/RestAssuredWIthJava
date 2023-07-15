package restAPIBDD;

import java.util.List;

import javax.annotation.meta.When;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	@Test
	public void test1() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get()
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("[1].name", Matchers.equalTo("David"));
	}
	@Test
	public void test2() {
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.when()
		.get("/3")
		.then()
		.log()
		.body()
		.statusCode(200)
		.body("name",Matchers.equalTo("Vidhya"));
	}
	@Test
	public void test3() {
		Response response = RestAssured.given()
							.baseUri("http://localhost:3000/employees")
							.when()
							.get();
		Assert.assertEquals(response.statusCode(), 200);
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		List<Integer> ids = json.get("id");
		int empId = 2;
		for(int i = 0; i < ids.size(); i++) {
			if(ids.get(i) == empId) {
				Assert.assertEquals(names.get(i), "David");
			}
		}
		
	}

}
