package practice_withBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest {
	@Test
	public void create() {
		JSONObject jobj = new JSONObject();
		
		jobj.put("createdBy", "user");
		jobj.put("projectName", "rmgYantra");
		jobj.put("projectId", "String");
		jobj.put("status","completed");
		jobj.put("teamSize", 20);
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all()
			.contentType("application/json");
	}

}
