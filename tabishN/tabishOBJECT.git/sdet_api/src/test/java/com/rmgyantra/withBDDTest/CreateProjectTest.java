package com.rmgyantra.withBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectTest {

	@Test
	public void create() {
		
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "tabish");
		jobj.put("projectName", "withBDD");
		jobj.put("status", "done");
		jobj.put("teamSize",17 );
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");
		
	}
}
