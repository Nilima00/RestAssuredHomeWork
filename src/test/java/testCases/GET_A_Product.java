package testCases;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_A_Product {
	SoftAssert sf = new SoftAssert();

	@Test
	public void read_A_Products() {

		Response response =

				given()
						// .log().all()
						.baseUri("https://techfios.com/api-prod/api/product")
						.header("Content-Type", "application/json;chatset=UFT-8").queryParam("id", "1209").when()
						// .log().all()
						.get("/read_one.php").then()
						// .log().all()
						.statusCode(200).extract().response();
		
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		// Assert.assertEquals(statusCode, 200 );
		sf.assertEquals(statusCode, 201, "Not matching");

		String responsebody = response.getBody().asString();
		//System.out.println(responsebody);
		
		JsonPath js = new JsonPath(responsebody);
		System.out.println(js);
		js.prettyPrint();
		
		String Id = js.getString("id");
		String Name = js.getString("name");
		String Description = js.getString("description");
		Assert.assertEquals(Id, "1209");
		Assert.assertEquals(Name, "HP Laptop Elite Pro");
		Assert.assertEquals(Description, "Super fast laptop");
		
		
		
		
		

		long responseTime = response.getTimeIn(TimeUnit.MICROSECONDS);
		System.out.println("ExecutionTime : " + responseTime);
		if (responseTime <= 2000) {
			System.out.println("Time is within the range");
		} else {
			System.out.println("Not good !");
		}

	}
}
