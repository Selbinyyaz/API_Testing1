package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods{
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement Pim;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployee;

	@FindBy(id = "firstName")
	public WebElement name;

	@FindBy(xpath = "//input[@id='middleName']")
	public WebElement middleName;

	@FindBy(id = "lastName")
	public WebElement lastN;

	@FindBy(id = "employeeId")
	public WebElement empId;

	@FindBy(id = "photofile")
	public WebElement photo;

	@FindBy(id = "btnSave")
	public WebElement savebtn;

	@FindBy(id = "empsearch_id")
	public WebElement searchid;

	@FindBy(id = "searchBtn")
	public WebElement search;

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement emplist;

	@FindBy(xpath = "//span[@for='firstName']")
	public WebElement requiredMsgfirstname;
	
	@FindBy(xpath = "//span[@for='lastName']")
	public WebElement requiredMsglastname;
	
	@FindBy(id="chkLogin")
	public WebElement checkbox;
	
	@FindBy(id="user_name")
	public WebElement username;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy(id="re_password")
	public WebElement userRePassword;
	
	@FindBy(xpath = "//select[@id='status']")
	public WebElement status;
	
	@FindBy(xpath = "//table[@id='resultTable']//td/a")
	public List<WebElement> data;


	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void createLoginCredentials(String Usrname,String pswrd,String repswrd) {
		sendText(username, Usrname);
		sendText(userPassword, pswrd);
		sendText(userRePassword, repswrd);
		Select select=new Select(status);
		select.selectByValue("Enabled");
		//click(savebtn);

	}
	public void verifyEmployee(String usern) {
		sendText(username, usern);
		click(search);
	}
}
