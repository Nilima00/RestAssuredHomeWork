package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_Read_AllProducts {

	
	@Test
	public void read_All_Products() {
		
		Response response=
		
		given()
		     .log().all()
		     .baseUri("https://techfios.com/api-prod/api/product")
		     .header("Content-Type", "application/json;chatset=UFT-8")
		.when()
		     .log().all()
		     .get("/read.php")
	    .then()
	        // .log().all()
	         .statusCode(200)
	         .extract().response();
	     int statusCode = response.getStatusCode();
		  System.out.println(statusCode); 
		  Assert.assertEquals(statusCode, 200 );
		  
		  String responsebody = response.getBody().asString();
		  //System.out.println(responsebody);
		  
		  
		  
		  
		
		
		
		
	}
}
