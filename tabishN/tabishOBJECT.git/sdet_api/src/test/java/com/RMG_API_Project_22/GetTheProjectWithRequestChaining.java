package com.RMG_API_Project_22;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetTheProjectWithRequestChaining {
	@Test
	public void getTheProject() {
	Response response = when()
			.get("http://localhost:8084/projects");

		String firstProId=response.jsonPath().get("[19].projectId");
		System.out.println(firstProId);
		
		given()
			.pathParam("proID", firstProId)
		.when()
			.get("http://localhost:8084/projects/{proID}")
		.then()
			.log().all()
			.assertThat().statusCode(200);
		
	
		
	
	}
}
