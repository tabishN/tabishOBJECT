package practice_withBDD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingRandomNumberTest {
	@Test
	public void create() {
		
		HashMap map = new HashMap();
		Random random = new Random();
		int randomNumber=random.nextInt(100);
		
		map.put("createdBy", "tabishMap");
		map.put("projectName", "MapwithBDD" + randomNumber);
		map.put("status", "done");
		map.put("teamSize",21 );
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");

}

}
