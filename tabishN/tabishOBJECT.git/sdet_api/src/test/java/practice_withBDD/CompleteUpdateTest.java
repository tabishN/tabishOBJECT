package practice_withBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CompleteUpdateTest {
	@Test
	public void update() {
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "userUpdated");
		jobj.put("projectName", "rmgyantraUpdated");
		jobj.put("status","updated");
		jobj.put("teamSize", 25);
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1405")
		.then()
			.log().all();
			
		
	}

}
