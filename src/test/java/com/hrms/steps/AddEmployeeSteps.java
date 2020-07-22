package com.hrms.steps;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddEmployeeSteps extends CommonMethods{

	@Given("user is logged with valid admin credentials")
	public void user_is_logged_with_valid_admin_credentials() {
	    login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("user navigates to AddEmployeePage")
	public void user_navigates_to_AddEmployeePage() {
	    click(addEmp.Pim);
	    click(addEmp.addEmployee);
	}

	@When("user enters employees {string} and {string}")
	public void user_enters_employees_and(String string, String string2) {
	    sendText(addEmp.name, string);
	    sendText(addEmp.lastN, string2);
	}

	@When("user clicks save button")
	public void user_clicks_save_button() {
	   click(addEmp.savebtn);
	}
	// this method is enhanced method and parameter values are supply
	@Then("{string} is added successfully")
	public void is_added_successfully(String expectName) {
	    String actualName=pdetails.profilePic.getText();
	    Assert.assertEquals(expectName, actualName);	    
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
	    addEmp.empId.clear();
	}
	// this method has hardcoded values

	@When("user enters employees first name and last name")
	public void user_enters_employees_first_name_and_last_name() {
		
		sendText(addEmp.name, "James");
		sendText(addEmp.lastN, "Smith");
	}

	@When("user enters login credentials as {string} and {string}")
	public void user_enters_login_credentials_as_and(String name, String lastname) {
		
		sendText(addEmp.name, name);
		sendText(addEmp.lastN, lastname);
	}

	@When("user clicks on create login checkbox")
	public void user_clicks_on_create_login_checkbox() {
		 click(addEmp.checkbox);
	}

	@When("user enters login credentials")
	public void user_enters_login_credentials() {
	    sendText(addEmp.username, "James123");
	  
        sendText(addEmp.userPassword, "Hum@nhrm123");
		
		sendText(addEmp.userRePassword, "Hum@nhrm123");
		wait(3);
		click(addEmp.savebtn);
		
	}
	// this method has hardcoded values
	@Then("employee is added successfully")
	public void employee_is_added_successfully() {
		String actual = pdetails.profilePic.getText();
		String expectedName = "James Smith";
		Assert.assertEquals(expectedName, actual);
	}

	@When("user enter employees {string}, {string} and {string}")
	public void user_enter_employees_and(String Fname, String Mname, String Lname) {
		sendText(addEmp.name, Fname);
		sendText(addEmp.middleName, Mname);
		sendText(addEmp.lastN, Lname);
	}

	@Then("{string}, {string} and {string} is added successfully")
	public void and_is_added_successfully(String fname, String mname, String lname) {

		System.out.println("I added the employee !!!!!!!!!!!!!!!!!!!!!!!");
		wait(2);
	}

	@When("user enters employee details and click on save then employee is added")
	public void user_enters_employee_details_and_click_on_save_then_employee_is_added(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> addEmployeeList = dataTable.asMaps();
		
		for (Map<String, String> map : addEmployeeList) {
			String fName = map.get("FirstName");
			String mname = map.get("MiddleName");
			String lname = map.get("LastName");

			sendText(addEmp.name, fName);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastN, lname);
			click(addEmp.savebtn);

			// adding assertion

			String actual = pdetails.profilePic.getText();
			String expected = fName + " " + mname + " " + lname;
			Assert.assertEquals("Employee is not addedd successfully", expected, actual);
			
			jsClick(dashboard.addEmployee);
			wait(5);
		}
	}

	@When("user enters employee data from {string} excel sheet then employee is added")
	public void user_enters_employee_data_from_excel_sheet_then_employee_is_added(String sheetName) {
		List<Map<String, String>> excelList = ExcelUtility.excelIntoListOfMaps(Constants.TESTDATA_FILEPATH, sheetName);

		for (Map<String, String> data : excelList) {
			String fname = data.get("FirstName");
			String mname = data.get("MiddleName");
			String lname = data.get("LastName");

			sendText(addEmp.name, fname);
			sendText(addEmp.middleName, mname);
			sendText(addEmp.lastN, lname);
			click(addEmp.savebtn);

			String actual = pdetails.profilePic.getText();
			String expected = fname + " " + mname + " " + lname;
			Assert.assertEquals("Employee is not addedd successfully", expected, actual);
			click(dashboard.addEmployee);

		}
	}
}
