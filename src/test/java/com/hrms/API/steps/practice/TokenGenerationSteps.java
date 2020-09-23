package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TokenGenerationSteps {
	
public static String token;
	 
String BaseURi = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	
	@Given("A JWT is generated")
	public void a_JWT_is_generated() {

		RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json").body("{\n" + 
				"  \"email\": \"selbi90@gmail.com\",\n" + 
				"  \"password\": \"hrm_@123\"\n" + 
				"}");
		
		Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
		
	//	generateTokenResponse.prettyPrint();
		
	 token ="Bearer "+generateTokenResponse.body().jsonPath().getString("token");
		System.out.println(token);
		
	}
}
