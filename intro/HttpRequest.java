package intro;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class HttpRequest {
//	@Test(priority=1)
	void listUsers()
	{	
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	@Test
	void createUser()
	{
		HashMap<String, String> data = new HashMap<>();
		data.put("name", "Somu");
		data.put("job","Software");
		
	 given()
	 	.contentType("application/json")
	 	.body(data)
	 
	 .when()
	 	.post("https://reqres.in/api/users")
	 .then()
	 	.statusCode(201)
	 	.log().all();
	 
	}
	

}
