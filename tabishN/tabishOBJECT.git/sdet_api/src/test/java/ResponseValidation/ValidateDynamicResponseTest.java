package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateDynamicResponseTest {
	@Test
	
	
	public void dynamicResponse() {

		String expectedData="rmg1";
		String actualData=null;
		Response response=when()
				.get("http://localhost:8084/projects");
		
				List<String> list = response.jsonPath().get("createdBy");
				
				boolean flag=false;
				for(String listdata:list) {
					if(listdata.equals(expectedData)){
						actualData=listdata;
						flag=true;
						//System.out.println("value is present is:"+ actualdata);
						break;
					}
				}
				
				Assert.assertEquals(flag,true);
				Assert.assertEquals(actualData,expectedData);
				response.then().statusCode(200).log().all();
					
	}
}