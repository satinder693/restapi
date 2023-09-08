package goRestAPIconcepts;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
//scenario -> create following test cases
// without token 
// with customer  NOT in DB
// with customer in DB
public class TC005_DELETEcall {
	HashMap map = new HashMap();
	public int custId = 1560409;
	@Test
	public void deleteCustomer() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/"+custId ;
		given()
			.headers("Authorization", "Bearer df2e394961f2fa9c00ba1ed5ae259f8cf9190bed1ace0345a9ba752254809bf8")
		.when()
			.delete()
		.then()
			.log().all()
			.statusCode(204);// 204 is the status code when we will delete.
			
		
		
	}

}
