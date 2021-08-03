package com.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuthTest {

	@Test
	public void basic() {
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
		.log().all().statusCode(202);
	}
}
