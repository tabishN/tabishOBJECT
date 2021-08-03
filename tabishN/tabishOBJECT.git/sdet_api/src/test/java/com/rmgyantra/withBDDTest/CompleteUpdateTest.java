package com.rmgyantra.withBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CompleteUpdateTest {
	@Test
	public void update() {
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy","Tabish BDD updated");
		jobj.put("projectName", "BDD_updated");
		jobj.put("status", "done");
		jobj.put("teamSize", 18);
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1404")
		.then()
		.log()
		.all();
	}

}
