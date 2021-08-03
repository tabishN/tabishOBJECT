package practice_withBDD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMapTest {
	@Test
	public void create() {
		
		HashMap map = new HashMap();
		
		map.put("createdBy", "tabishMap");
		map.put("projectName", "MapwithBDD");
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