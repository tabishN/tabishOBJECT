package com.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2 {

	@Test
	public void auth2() {
		Response response = given()
			.formParam("client_id", "Appilication 1")
			.formParam("client_secret","07819f4088d23258b816d251afad275c")
			.formParam("grant_type","client_credentials")
			.formParam("redirect_uri", "http://example.com")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		System.out.println(response.prettyPrint());
		
		String token=response.jsonPath().get("access_token");
		
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID","2133")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
			.then().log().all();
	}
	
}
