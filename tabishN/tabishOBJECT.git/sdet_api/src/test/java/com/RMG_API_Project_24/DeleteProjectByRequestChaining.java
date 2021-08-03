package com.RMG_API_Project_24;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteProjectByRequestChaining {
	@Test
	public void delete() {
		Response response = when()
				.get("http://localhost:8084/projects");
		String firstProId=response.jsonPath().get("[24].projectId");
		System.out.println(firstProId);
		
		given()
			.pathParam("proID", firstProId)
		.when()
			.delete("http://localhost:8084/projects/{proID}")
		.then()
			.log().all()
			.assertThat().statusCode(204);
		

}
}
