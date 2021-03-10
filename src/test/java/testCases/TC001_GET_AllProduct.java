package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_AllProduct {

	SoftAssert softassert = new SoftAssert();

	@Test
	void getalltheproducts() {
		RestAssured.baseURI = "https://techfios.com/api-prod/api/product";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/read_one.php?id=1363");
		
		String body = response.getBody().asString();
		System.out.println(body);

		int status = response.getStatusCode();
		System.out.println(status);
		softassert.assertEquals(status, 200, "ALL GOOD");
		
		Assert.assertEquals(body.contains("LAPTOP"),true);

		// String line = response.getStatusLine();

		softassert.assertAll();
	}

}
