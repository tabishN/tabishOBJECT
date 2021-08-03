package com.rmgyantra.withBDDTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectTest {

	@Test
	public void deleteProjects() {
		
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_603")
		.then()
			.assertThat().statusCode(204)
			.and()
			.log().all();
	}
}
