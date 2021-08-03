package com.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PreemptiveAndDigestiveAuthTest {
	@Test
	public void preemptive() {
		given()
		
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
		
	.when()
		.get("http://localhost:8084/projects")
	.then()
		.log().all().assertThat().statusCode(200);
		
	}
	@Test
	public void digestive() {
		given()
			.auth()
			.digest("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/projects")
		.then()
			.log().all().assertThat().statusCode(200);
		
	}

}
