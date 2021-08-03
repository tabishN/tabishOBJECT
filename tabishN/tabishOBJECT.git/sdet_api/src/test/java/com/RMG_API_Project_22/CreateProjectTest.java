package com.RMG_API_Project_22;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectTest {
	@Test
	public void create() {
		
		
JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "rmg1234");
		jobj.put("projectName", "rmgProject1234");
		jobj.put("projectId", "String");
		jobj.put("status","created");
		jobj.put("teamSize", 10);
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.post("http://localhost:8084/addProject")
		
		.then()
			.log().all()
			.contentType("application/json");		

}
}