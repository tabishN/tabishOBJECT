package com.Requestchaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

public class ChainingTest {
	@Test
	public void chain() {
		Response response = when()
				.get("http://localhost:8084/projects");
		String firstProId=response.jsonPath().get("[2].projectId");
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
