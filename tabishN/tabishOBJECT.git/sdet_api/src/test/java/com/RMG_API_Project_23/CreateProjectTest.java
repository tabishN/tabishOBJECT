package com.RMG_API_Project_23;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest {
	@Test
	public void create() {
		
		
JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "rmg65");
		jobj.put("projectName", "rmgProject65");
		jobj.put("createdOn", "26/05/2021");
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
			.contentType("application/json");	}

}
