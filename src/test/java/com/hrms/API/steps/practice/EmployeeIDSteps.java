//package com.syntax.steps;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.junit.Assert;
//
//import com.syntax.api.utils.ApiConstants;
//import com.syntax.api.utils.PayloadConstant;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class EmployeeIDSteps {
//
//	String BaseURi = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
//
//	RequestSpecification request;
//
//	Response response;
//
//	public static String employeeID;
//
//	@Given("a request is prepared to create an employee")
//	public void a_request_is_prepared_to_create_an_employee() {
//
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationStep.token)
//				.body(PayloadConstant.createEmpBody());
//
//	}
//
//	@When("a Post call is made to create an employee")
//	public void a_Post_call_is_made_to_create_an_employee() {
//		response = request.when().post(ApiConstants.CREATE_EMPLOYEE_ENDPOINT);
//	}
//
//	// Check if the status code is 201
//	@Then("user receive valid HTTP response code {int}")
//	public void user_receive_valid_HTTP_response_code(Integer statusCode) {
//
//		response.then().assertThat().statusCode(statusCode);
//	}
//
//	@Then("the employee is created and response contains key {string} and value {string}")
//	public void the_employee_is_created_and_response_contains_key_and_value(String key, String value) {
//		response.then().assertThat().body(key, equalTo(value));
//	}
//
//	@Then("the employee ID {string} is stored as a global variable to be used for other calls")
//	public void the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(String empId) {
//		employeeID = response.body().jsonPath().getString(empId);
//		System.out.println(employeeID);
//	}
//
//	@Given("a request is prepared to retrieve the created employee")
//	public void a_request_is_prepared_to_retrieve_the_created_employee() {
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationStep.token)
//				.queryParam("employee_id", employeeID);
//	}
//
//	@When("a Get call is made to retrieve the created employee")
//	public void a_Get_call_is_made_to_retrieve_the_created_employee() {
//		response = request.when().get(ApiConstants.GET_ONE_EMPLOYEE_ENDPOINT);
//	}
//
//	@Then("the retrieved employee ID {string} matches the globally stored employee ID")
//	public void the_retrieved_employee_ID_matches_the_globally_stored_employee_ID(String value) {
//		String empId = response.body().jsonPath().getString(value);
//		Assert.assertTrue(empId.contentEquals(employeeID));
//	}
//
//	@Then("the retrieved data at {string} matches the data used to create an employee with employee ID {string}")
//	public void the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(
//			String employeeObject, String responseEmployeeID, DataTable dataTable) {
//
//		List<Map<String, String>> expectedData = dataTable.asMaps();
//		List<Map<String, String>> actualData = response.andReturn().jsonPath().get(employeeObject);
//
//		int index = 0;
//		for (Map<String, String> map : expectedData) {
//			Set<String> keys = map.keySet();
//			for (String key : keys) {
//				String expectedValue = map.get(key);
//				String actualValue = actualData.get(index).get(key);
//				Assert.assertEquals(expectedValue, actualValue);
//			}
//			index++;
//		}
//		String empId = response.body().jsonPath().getString(responseEmployeeID);
//		Assert.assertTrue(empId.contentEquals(employeeID));
//
//	}
//
//	@Given("a request is prepared to update the created employee")
//	public void a_request_is_prepared_to_update_the_created_employee() {
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationStep.token)
//				.queryParam("employee_id", employeeID).body(PayloadConstant.updateEmpBody());
//	}
//
//	@When("a Put call is made to update the created employee")
//	public void a_Put_call_is_made_to_update_the_created_employee() {
//		response = request.when().put(ApiConstants.UPDATE_EMPLOYEE_ENDPOINT);
//		response.prettyPrint();
//	}
//
//	@Then("the employee is updated and response contains key {string} and value {string}")
//	public void the_employee_is_updated_and_response_contains_key_and_value(String key, String value) {
//		response.then().assertThat().body(key, equalTo(value));
//	}
//
//	@Then("the updated data at {string} matches the data used to create an employee with employee ID {string}")
//	public void the_updated_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(String employeeObject,
//			String responseEmployeeID, DataTable dataTable) {
//		List<Map<String, String>> expectedData = dataTable.asMaps();
//		List<Map<String, String>> actualData = response.andReturn().jsonPath().get(employeeObject);
//
//		int index = 0;
//		for (Map<String, String> map : expectedData) {
//			Set<String> keys = map.keySet();
//			for (String key : keys) {
//				String expectedValue = map.get(key);
//				String actualValue = actualData.get(index).get(key);
//
//				Assert.assertEquals(expectedValue, actualValue);
//			}
//			index++;
//
//		}
//		String empId = response.body().jsonPath().getString(responseEmployeeID);
//		Assert.assertTrue(empId.contentEquals(employeeID));
//
//	}
//
//	@Given("a request is prepared to partially update the created employee")
//	public void a_request_is_prepared_to_partially_update_the_created_employee() {
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationStep.token)
//				.body(PayloadConstant.partiallyUpdateBody());
//	}
//
//	@When("a Patch call is made to partially update the created employee")
//	public void a_Patch_call_is_made_to_partially_update_the_created_employee() {
//		response = request.when().patch(ApiConstants.PARTIAL_UPDATE_EMPLOYEE_ENDPOINT);
//		response.prettyPrint();
//	}
//
//	@Then("user verifies partially updated employee job title at {string} matches the {string}")
//	public void user_verifies_partially_updated_employee_job_title_at_matches_the(String empJobTitle, String value) {
//
//		String jobTitle = response.body().jsonPath().getString(empJobTitle);
//
//		Assert.assertTrue(jobTitle.contentEquals(value));
//	}
//
//	@Given("a request is prepared to delete the created employee")
//	public void a_request_is_prepared_to_delete_the_created_employee() {
//		request = given().header("Content-Type", "application/json").header("Authorization", TokenGenerationStep.token)
//				.queryParams("employee_id", employeeID);
//	}
//
//	@When("a Delete call is made to delete the created employee")
//	public void a_Delete_call_is_made_to_delete_the_created_employee() {
//		response = request.when().delete(ApiConstants.DELETE_EMPLOYEE_ENDPOINT);
//	}
//
//	@Then("user is deleted and response contains key {string} and value {string}")
//	public void user_is_delete_and_response_contains_key_and_value(String key, String value) {
//		response.then().assertThat().body(key, equalTo(value));
//	}
//
//}
