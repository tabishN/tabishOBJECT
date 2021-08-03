package practice_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test
	public void delete() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_606")
		.then()	
			.assertThat().statusCode(500)
			.and()
			.log()
			.all();
	}
}
