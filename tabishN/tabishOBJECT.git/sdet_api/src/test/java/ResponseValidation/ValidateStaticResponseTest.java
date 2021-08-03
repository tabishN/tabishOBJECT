package ResponseValidation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateStaticResponseTest {

	@Test
	public void staticResponse() {
		String  expectedProjectName="sample1";
		Response response=when()
				.get("http://localhost:8084/projects");
		response.then()
				.assertThat().statusCode(200)
				.log().all();
		String actualProjectName=response.jsonPath().get("[0].projectName");
		System.out.println("expected value is:"+ expectedProjectName);
		System.out.println("actual value is"+ actualProjectName);
		
		Assert.assertEquals(actualProjectName, expectedProjectName);
		
	}
}
