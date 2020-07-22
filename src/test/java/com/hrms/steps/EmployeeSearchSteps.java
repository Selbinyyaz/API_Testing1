package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.GlobalVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

	@Given("user navigate to employee list page")
	public void user_navigate_to_employee_list_page() {
		click(addEmp.Pim);
		wait(2);
		click(addEmp.emplist);
	    
	}

	@When("user enters valid employee id {string}")
	public void user_enters_valid_employee_id(String id) {
		
		sendText(viewEmp.empID, id);
		GlobalVariables.empId= id;
		
	    
	}

	@When("click on search button")
	public void click_on_search_button() {
	    click(viewEmp.search);
	}

	@Then("user see employee information is displayed")
	public void user_see_employee_information_is_displayed() {
	    System.out.println("Employee is displayed");
	}

	@When("user enters valid employee {string} and {string}")
	public void user_enters_valid_employee_and(String name, String lastname) {
	    sendText(viewEmp.empName, name );
	    sendText(viewEmp.empName, lastname );
	    click(viewEmp.search);
	    wait(3);
	}

	@Then("verify table is displayed")
	public void verify_table_is_displayed() {
	    Assert.assertEquals(true, viewEmp.isTableDisplayed());
	}

	@Then("get first name from table")
	public void get_first_name_from_table() {
		System.out.println(viewEmp.getLastNameFromTable());
	    
	}
	@Then("varify first name from UI against DB")
	public void varify_first_name_from_UI_against_DB() {
	   Assert.assertEquals(DBSteps.dbData, viewEmp.getLastNameFromTable());
	}
}
