package com.rmgyantra.withoutBDDTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class GetAllProjectTest {
	@Test
	public void getallProject() {
		Response response = RestAssured.get("http://localhost:8084/projects");
		System.out.println(response.asString());
		response.prettyPrint();
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		
		/*
		* int actualStatusCode=response.getStatusCode();
		* Assert.assertEquals(actualStatusCode, 200);
		*/
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(200);
	}

}
