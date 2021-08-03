package com.rmgyantra.projectTest;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projectpojolibrary.ProjectLib;

public class CreateProjectWithCompletedStatusTest {
	
	@Test
	
	public void createProjectWithCompletedStatus() throws Throwable {
		Random random=new Random();
		int randomNumber=random.nextInt(1000);
		String expectedProjectName="TeamIndia"+randomNumber;
		String expectedStatus="completed";
		 //create a resource inside the server using pojo class
		ProjectLib projectlib = new ProjectLib("virat", expectedProjectName, expectedStatus, 15);
		
		//give precondition and capture the response after doing post operation
			Response response = given()
				.contentType(ContentType.JSON)
				.body(projectlib)
				.when()
				.post("http://localhost:8084/addProject");
			
			//capture project name and statuscode from the response
			String responseProjectName=response.jsonPath().getString("projectName");
			String responseStatus =response.jsonPath().getString("status");
			
			//provide the restAssured verification
			
			response.then()
				.assertThat().statusCode(201)
				.assertThat().contentType(ContentType.JSON)
				.log().all();
			
			//register the database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//connect to mysql database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
			//create the statement
			  Statement statement = connection.createStatement();
			  
			  //execute query and get the values from database
			  String actualProjectName=null;
			  String actualStatus=null;
			  boolean flag=false;
			  ResultSet result = statement.executeQuery("select * from project");
			  while(result.next()) {
				  if(result.getString(4).equals(expectedProjectName)) {
					  actualProjectName=result.getString(4);
					  actualStatus=result.getString(5);
					  flag=true;
					  break;
				  }
			  }
			  connection.close();
			  
			  //assertion using flag between expected and actual from database
			  Assert.assertEquals(flag,true);
			  //verification between expected and actual from database
			  Assert.assertEquals(actualProjectName,expectedProjectName);
			  //verification between expected and from response
			  Assert.assertEquals(responseProjectName, expectedProjectName);
			  
				
				
				

				
	}

}
