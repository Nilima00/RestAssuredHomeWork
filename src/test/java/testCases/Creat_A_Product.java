package testCases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class Creat_A_Product {

	SoftAssert sf = new SoftAssert();

	@Test
	public void creat_A_Product() {

		HashMap payload = new HashMap();
		payload.put("name", "Book");
		payload.put("description", "Story");
		payload.put("price", "$25");
		payload.put("category_id", "6");
		payload.put("category_name","Books");
		
		Response response =

				given()
						// .log().all()
						.baseUri("https://techfios.com/api-prod/api/product")
						.header("Content-Type", "application/json;chatset=UFT-8")
						.body(payload)
						 .when()
						// .log().all()
						.post("/create.php")
						.then()
						// .log().all()
						.extract().response();
		
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);

}}
