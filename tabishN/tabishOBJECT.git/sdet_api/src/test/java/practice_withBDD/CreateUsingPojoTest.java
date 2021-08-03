package practice_withBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import projectpojolibrary.ProjectLib;

import static io.restassured.RestAssured.*;


public class CreateUsingPojoTest {
	@Test
	public void createpojo() {
		ProjectLib pojoObject = new ProjectLib("tabishPOJO","demoProject","done",610);
			given()
				.contentType(ContentType.JSON)
				.body(pojoObject)
			.when()
				.post("http://localhost:8084/addProject")
			.then()
				.log().all()
				.assertThat().statusCode(201);
				
	}
}
