package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST {
	
	SoftAssert softassert = new SoftAssert();
	@Test
	  void creatAProduct() {
		
		HashMap payload = new HashMap();
		payload.put("name", "LAPTOP");
		payload.put("description", "Fast");
		payload.put("price", "1234");
		payload.put("category_id", "2");
		payload.put("category_name", "Electronics");
		
		
		
		
	Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
		.when()
		    .post("/create.php")
		.then()
		    .extract().response();
	    String res = response.getBody().asString();
	    System.out.println(res);
	    
		
		  JsonPath js = new JsonPath(res); String items = js.getString("message");
		  System.out.println(items);
		  
		 
	    
	  softassert.assertEquals(items,"Product was created.","done");
	 softassert.assertAll();
	 
	
	    
		
		
		}
}
	
	


