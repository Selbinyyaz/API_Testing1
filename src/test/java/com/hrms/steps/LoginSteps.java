package com.hrms.steps;

import org.junit.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends CommonMethods {
	
	@When("user enter valid admin username and password")
	public void user_enter_valid_admin_username_and_password() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		click(login.loginBtn);
	}

	@Then("admin user is successfully logged in")
	public void admin_user_is_successfully_logged_in() {
		String expect=dashboard.welcome.getText();
		String actual="Welcome Admin";
		Assert.assertEquals(expect, actual);
	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);
		
	}

	@Then("{string} is successfully logged in")
	public void is_successfully_logged_in(String string) {
		
	}

	

	@When("user enter valid ess username and password")
	public void user_enter_valid_ess_username_and_password() {
		
	}

	@Then("ess user is successfully logged in")
	public void ess_user_is_successfully_logged_in() {
		
	}

	@When("user enter valid {string} and {string}")
	public void user_enter_valid_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);
	}

	@When("User enter valid username and invalid password")
	public void user_enter_valid_username_and_invalid_password() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User see Invalid Credentials text on login page")
	public void user_see_Invalid_Credentials_text_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter invalid username and password and see error message")
	public void i_enter_invalid_username_and_password_and_see_error_message(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}
	
	@Then("user see {string}")
	public void user_see(String errorMsg) {
		Assert.assertEquals(errorMsg, login.errormsg.getText());
	}

}
