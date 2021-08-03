package com.RMG_API_Project_23;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProjectWithRequestChaining {
	@Test

	public void update() {
	JSONObject jobj = new JSONObject();
	
	jobj.put("createdBy", "rmgUpdatedN");
	jobj.put("projectName", "rmgyantraUpdatedN");
	jobj.put("status","updated");
	jobj.put("teamSize", 10);
	
	given()
		.contentType(ContentType.JSON)
		.body(jobj)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_2203");
	
	Response response = when()
			.get("http://localhost:8084/projects");
	String firstProId=response.jsonPath().get("[20].projectId");
	System.out.println(firstProId);
	
	given()
		.pathParam("proID", firstProId)
	.when()
		.put("http://localhost:8084/projects/{proID}")
	.then()
		.log().all()
		.assertThat().statusCode(201);

		

}
}