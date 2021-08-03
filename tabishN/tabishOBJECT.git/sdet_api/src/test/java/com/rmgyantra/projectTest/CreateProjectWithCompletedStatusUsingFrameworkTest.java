package com.rmgyantra.projectTest;

import org.testng.annotations.Test;

import com.rmgyantra.GenericUtils.BaseAPIClass;
import com.rmgyantra.GenericUtils.DataBaseUtilities;
import com.rmgyantra.GenericUtils.EndPoints;
import com.rmgyantra.GenericUtils.JavaUtility;
import com.rmgyantra.GenericUtils.JsonUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectpojolibrary.ProjectLib;

public class CreateProjectWithCompletedStatusUsingFrameworkTest extends BaseAPIClass{
	@Test
	public void createProject() {
		JavaUtility javautils = new JavaUtility();
		JsonUtility jsonUtils = new JsonUtility();		
		DataBaseUtilities dbUtility = new DataBaseUtilities();
		
		String expectedProjectName="Teamindia"+javautils.randomNumber();
		String expectedStatus="completed";
		
		//create a resource inside the server using pojo class
		ProjectLib projectlib = new ProjectLib("virat", expectedProjectName, expectedStatus, 15);
		
		//give precondition and capture the 	response after doing post operation
		Response response=given()
				.contentType(ContentType.JSON)
				.body(projectlib)
			.when().post(EndPoints.addProject_EP);
		
		
	}
	
	
	
}
