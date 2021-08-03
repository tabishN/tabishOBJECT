package Create_Project_and_Allocate_USER;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class API_TC_1 {
		@Test
		public void end2end() {
			JSONObject jobj = new JSONObject();
			
			jobj.put("createdBy", "deepak");
			jobj.put("projectName", "Airtelll");
			jobj.put("status","Completed");
			jobj.put("teamSize", 12);
			
			given()
				.contentType(ContentType.JSON)
				.body(jobj)
			.when()
				.post("http://localhost:8084/addProject")
			
			.then()
				.log().all().statusCode(201);
			
			
		
		}
}
		
	


