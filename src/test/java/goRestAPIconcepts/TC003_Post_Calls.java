package goRestAPIconcepts;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured; 
public class TC003_Post_Calls {
	public HashMap map = new HashMap();
	@Test
	public void createCustomerDetails() {// scenario 1 ->
		// now if we dont want to enter name and email everytime we create a customer--> we will use a java command, RandomStringUtils-->
		// this generates alphabets and numbers randomly. its a string value. assign a name.
		String cusName = RandomStringUtils.randomAlphabetic(5);
		String cusEmail = RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(3);
		
		map.put("name", cusName);
		map.put("email", cusEmail+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "inactive");
		// scenario 2 -> if we do not want to enter the uri again and again in .post()-->
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users" ;// copied from POST.
		given()
		.contentType("application/json")
		.headers("Authorization", "Bearer df2e394961f2fa9c00ba1ed5ae259f8cf9190bed1ace0345a9ba752254809bf8")
		.body(map)
		.when()
			.post()
		.then()
		
			.log().all()
		// NOW IF WE HAVE TO VALIDATE THE INFO IN THE CUSTOMER DETAILS WE CREATED-->
			.body("name", equalTo(cusName))
			.body("email", equalTo(cusEmail+"@gmail.com"));
	}
	
	
	

}
