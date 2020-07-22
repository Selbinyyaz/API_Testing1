package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.*;
import org.junit.Assert;

//import org.apache.hc.core5.http.ContentType;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 *This will execute @test annotation is ascending alphabetical order
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples {

	/**
	 * Rest Assured given - prepare your request when - you are making the call to
	 * the endpoint then - validating
	 * 
	 * @param args
	 */

	static String BaseURi = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	
	String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjk2NTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMjg1NiwidXNlcklkIjoiNjU4In0.dJU7RFjphPtfSUz0iHXzEtheh4WJZGESDKbzRYIAJO0";
	
	public static String employeeID;

	public void sampleTestNotes() {
		/**
		 * BaseURI for all calls
		 */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**
		 * JWT required for all calls- expires every 12 hours
		 */

		//String token = " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg2MzEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTgzMSwidXNlcklkIjoiNjU4In0.7WSH-Nua7YkkD4ORRnqheRcasm4jQ-F0TZkLygxNbV0";
		/**
		 * Preparing /getOneEmployee.php request
		 */
		RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", "16526A");

		/**
		 * Storing response
		 */
		Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

		/**
		 * Two ways to print response
		 */
		getOneEmployeeResponse.prettyPrint();

		getOneEmployeeResponse.then().assertThat().statusCode(201);

	}
	@Test
	public void aPostcreateEmployee() {
		/**
		 * Preparing request for /createEmployee.php
		 */
		RequestSpecification createEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).body("{\n" + 
						"  \"emp_firstname\": \"syntaxFirstName\",\n" + 
						"  \"emp_lastname\": \"syntaxLastName\",\n" + 
						"  \"emp_middle_name\": \"syntaxMiddleName\",\n" + 
						"  \"emp_gender\": \"F\",\n" + 
						"  \"emp_birthday\": \"2000-07-11\",\n" + 
						"  \"emp_status\": \"Employee\",\n" + 
						"  \"emp_job_title\": \"Cloud Architect\"\n" + 
						"}");
		/**
		 * Storing response into createEmployeeResponse
		 */
		
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
		
		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.print();
		
		/**
		 * jsonPath() to view response body which lets us get the employee id we store employee id 
		 * as global variable so that we may we use it with our other calls
		 */
		employeeID=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		System.out.println(employeeID);
		/**
		 * verifying response status code is 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * verifying message using equalto() method -manually import static
		 * package import static org.hamcrest.matchers
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		/**
		 * verifying created first name
		 */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("syntaxFirstName"));
		/**
		 *Verifying server using then().header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		/**
		 *Verifying Content type using then().assertthat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
		
		
		
	}
	
	@Test
	public void bGetcreatedEmployee() {
		/**
		 * Preparing request for /getOneEmployee.php
		 */
		RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
				.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
		/**
		 * Makig call to retrieve created employee
		 */
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");

		String response=getCreatedEmployeeResponse.prettyPrint();

		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

		boolean verifyingEmployeeIDsMatch = empID.equalsIgnoreCase(employeeID);
		
		System.out.println("Employee Id match = "+employeeID);
		/**
		 * Asserting employee id's match
		 */

		Assert.assertTrue(verifyingEmployeeIDsMatch);

		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		JsonPath js= new JsonPath(response);
		String emplID=js.getString("employee[0].employee_id");
		String firstName=js.getString("employee[0].emp_firstname");
		String middleName=js.getString("employee[0].emp_middle_name");
		String lastName=js.getString("employee[0].emp_lastname");
		String emp_bday=js.getString("employee[0].emp_birthday");
		String gender =js.getString("employee[0].emp_gender");
		String jobTitle =js.getString("employee[0].emp_job_title");
		String empStatus=js.getString("employee[0].emp_status");
		
		System.out.println(emp_bday);
		System.out.println(firstName);
		/**
		 * verifying employee id's match
		 */
		Assert.assertTrue(emplID.contentEquals(employeeID));
		//second way of asserting
		Assert.assertEquals(employeeID,emplID);
		
		/** Verifying expected first name matches actual first name */
		Assert.assertTrue(firstName.contentEquals("syntaxFirstName"));
		
		/**Verifying expected middlename matches actual middle name */
		Assert.assertTrue(middleName.contentEquals("syntaxMiddleName"));
		
		/**Verifying expected lastname matches actual last name */
		Assert.assertTrue(lastName.contentEquals("syntaxLastName"));
		
		/**Verifying expected empbirday matches actual birthday */
		Assert.assertTrue(emp_bday.contentEquals("2000-07-11"));
		
		/**Verifying expected gender matches actual gender */
		Assert.assertTrue(gender.contentEquals("Female"));
		
		/**Verifying expected jobtitle matches actual job title */
		Assert.assertTrue(jobTitle.contentEquals("Cloud Architect"));
		
		/**Verifying expected emp status  matches actual status */
		Assert.assertTrue(empStatus.contentEquals("Employee"));
		
		
	}
	@Test
	public void cGetallEmployees() {
		RequestSpecification getAllEmployeesRequest = given().header("Content-Type","application/json").header("Authorization",token);
		
		Response getAllEmployeesResponse = getAllEmployeesRequest.when().get("/getAllEmployees.php");
		
		//getAllEmployeesResponse.prettyPrint();
		
		String allEmployees = getAllEmployeesResponse.body().asString();

		/** The below will pass but incorrect */
		// allEmployees.contains(employeesID);
		// allEmployees.matches(employeeID);

		JsonPath js = new JsonPath(allEmployees);

		int sizeOfList = js.getInt("Employees.size()");
		System.out.println(sizeOfList);

//		for (int i = 0; i < sizeOfList; i++) {
//			
//			String allEmployeeIDs = js.getString("Employees[" + i + "].employee_id");
//
//			//System.out.println(allEmployeeIDs);
//			
//			if(allEmployeeIDs.contentEquals(employeeID)) {
//				System.out.println("Employee ID: "+employeeID+" is present in body");
//				String employeeFirstName=js.getString("Employees[" + i + "].emp_firstname");
//				System.out.println(employeeFirstName);
//				
//				break;
//			}
//		}
	}

	@Test
	public void dPutupdateCreatedEmployee() {

		RequestSpecification updateCreatedEmployeeRequest = given().header("Content-Type","application/json").header("Authorization",token).body(HardcodedConstants.updateCreatedEmpBody());
		
		Response updateCreatedEmployeeResponse = updateCreatedEmployeeRequest.when().put("/updateEmployee.php");
		
		String response=updateCreatedEmployeeResponse.prettyPrint();
	}

	@Test
	public void eGetupdatedEmployee() {
		
	}

	@Test
	public void fPatchpartiallyUpdating() {
		
	}

	@Test
	public void gGetpartiallyUpdatedEmployee() {
		
	}

	@Test
	public void hDeletedeletingEmployee() {
		
	}
	
	@Test
	public void lGetEmployeeStatus() {
		
	}
	
	@Test
	public void mGetJobTitles() {
		
	}

}

