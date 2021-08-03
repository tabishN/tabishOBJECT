package Create_Project_and_Allocate_USER;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class End2EndTest {
	
	@Test
	public void passProjectName() {
		Response response = when()
				.get("http://localhost:8084/projects");

			String firstProId=response.jsonPath().get("[25].projectName");
			System.out.println(firstProId);
			
			
			
			JSONObject job = new JSONObject();

			
			job.put("designation", "SDET");
			job.put("dob", "25/05/1999");
			job.put("email","nithesh@gmail.com");
			job.put("empName", "nithesh");
			job.put("experience", 15);
			job.put("mobileNo", "9888777657");
			job.put("project", "{{projectName}}");
			job.put("empName", "nithesh");
			job.put("empName", "nithesh");
			
			given()
				.contentType(ContentType.JSON)
				.body(job)
			.when()
				.post("http://localhost:8084/employees")
			.then()
			.log().all()
			.assertThat().statusCode(201);
			
			
		
		 
	}

}
