package goRestAPIconcepts;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import javax.mail.internet.ContentType;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

// these calls are for updating the details.
// in order to modify the data --> we need to pass the payload,content type, token(authorization), url.
// we can create positive and negative test cases.
// ex --> 
/* tests that we can write in this are -->
1. without payload
2. without authorization
3. wrong authorization
4. without name
5. without email
6. same email
7. without gender
8. without status*/
/*scenario --> update the details of -->  "id": 1560409,
"name": "Pres. Brijesh Sinha",
"email": "pres_brijesh_sinha@emard.example",
"gender": "male",
"status": "inactive"*/
/*step 1 -> create public void updateDetails()
// 2 -> import static io.restassured.RestAssured.*;// these are imported above
        import static org.hamcrest.Matchers.*; // without these both we cannot write -> given , when , then , and.
   3 -> create HashMap concept. to use hashmap concept , 1st we've to import io.restassured.RestAssured.* & org.hamcrest.Matchers.*
   hashmap concept is created on the class level
   4 -> @Test -> above the actual test
   5-> develop the code --> scenario -> we have to update the name and the email. -> build the payload. 
   6-> we have to pass the customer id 
*/
public class TC004_PUTorPATCHcalls {
	HashMap map = new HashMap();
	public int custId = 1560409;// step 6
	@Test
	public void updateDetails() {
		String cusName = RandomStringUtils.randomAlphabetic(5);
		String cusEmail = RandomStringUtils.randomAlphabetic(5)+RandomStringUtils.randomNumeric(3)+"gmail.com";
		map.put("name", cusName);
		map.put("email", cusEmail);  
		map.put("gender", "male");
		map.put("status", "inactive");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/"+custId ;
		given()
			.contentType("application/json")
			.headers("Authorization", "Bearer df2e394961f2fa9c00ba1ed5ae259f8cf9190bed1ace0345a9ba752254809bf8")
			.body(map)
		.when()
			.put()
		.then()
			
			.log().all()
			.body("name", equalTo(cusName)) // to validate the details
			.body("email", equalTo(cusEmail));
		
		
	}
}
