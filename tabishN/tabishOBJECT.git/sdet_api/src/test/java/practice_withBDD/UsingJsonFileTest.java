package practice_withBDD;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingJsonFileTest {
	@Test
	public void usingjsonfile() {
		File file=new File("./datas.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.log().all().and()
			.assertThat().contentType("application/json");
			
		
	}

}
