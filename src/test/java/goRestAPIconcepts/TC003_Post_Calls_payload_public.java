package goRestAPIconcepts;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured; 
public class TC003_Post_Calls_payload_public {
	public HashMap map = new HashMap();
	public String cusName;// create both these so that they are accessable for the test case below.
	public String cusEmail;
	@BeforeClass
	public void generatePayload() { // these steps are not test case steps, these are precondition steps. 
		cusName = RandomStringUtils.randomAlphabetic(5);
		cusEmail = RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(3);
		map.put("name", cusName);
		map.put("email", cusEmail+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "inactive");
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users" ;
	}
	@Test
	public void createCustomerDetails() {
		
		given()
		.contentType("application/json")
		.headers("Authorization", "Bearer df2e394961f2fa9c00ba1ed5ae259f8cf9190bed1ace0345a9ba752254809bf8")
		.body(map)
		.when()
			.post()
		.then()
		
			.log().all()
		
			.body("name", equalTo(cusName))//to validate details of customer
			.body("email", equalTo(cusEmail+"@gmail.com"));
	}
	/*other tests that we can write in this are -->
	1. without payload
	2. without authorization
	3. wrong authorization
	4. without name
	5. without email
	6. same email
	7. without gender
	8. without status*/
	}
