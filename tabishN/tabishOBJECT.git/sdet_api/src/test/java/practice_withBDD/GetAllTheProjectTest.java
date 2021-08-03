package practice_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllTheProjectTest {
	@Test
	public void getTheProject() {
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
