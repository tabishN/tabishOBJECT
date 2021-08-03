package com.rmgyantra.withBDDTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAllProjectTest {
	@Test
	public void getProjects() {
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().contentType("application/json")
			.and()
			.log().all();
			
			
		
		
	}

}
