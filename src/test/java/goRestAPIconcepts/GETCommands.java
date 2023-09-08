package goRestAPIconcepts;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

//import io.restassured.response.Response;

public class GETCommands {

	
	@Test(priority=1, enabled=false)
	public void getDetailsBasedOnId() {
		given()
		.when()
			.get("https://gorest.co.in/public/v2/users")
		.then()
			.log().all();
		
	}
	@Test(priority=2, enabled=false)
	public void getDetailsBasedOnInvalidId() {
		given()
		.when()
			.get("https://gorest.co.in/public/v2/users/15162302")
		.then()
			.log().all()
			.statusCode(404)
			.body("message", equalTo("Resource not found")); // equalTo is coming from the hamcrest
			
	}
	@Test
	public void getDetailsWithInvalidID() {
		Response resp =  given()
		.when()
			.get("https://gorest.co.in/public/v2/users/15162302");
		//System.out.println(resp.prettyPrint());
		int statusCode = resp.getStatusCode();
		Assert.assertEquals(statusCode, 404);
		
	
	}
	
}