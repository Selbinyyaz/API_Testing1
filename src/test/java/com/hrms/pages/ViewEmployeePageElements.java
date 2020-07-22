package com.hrms.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ViewEmployeePageElements extends CommonMethods {

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement empName;

	@FindBy(id = "empsearch_id")
	public WebElement empID;
	
	@FindBy(id="searchBtn")
	public WebElement search;
	
	@FindBy(xpath = "//table[@id='resultTable']//td/a")
	public List<WebElement> data;

	
	@FindBy (xpath="(//table[@id='resultTable']//td/a)[2]")
	public WebElement empSrcFirstName;
	
	@FindBy (xpath = "//table[@id='resultTable']")
	public WebElement employeesTable;
	
	@FindBy (xpath = "//table[@id='resultTable']//tbody/tr/td[3]")
	public List<WebElement> tableFirstName;
	
	@FindBy (xpath = "//table[@id='resultTable']//tbody/tr/td[4]")
	public List<WebElement> tableLastName;
	
//	
//	@FindBy (xpath="//table[@id='resultTable']//td/a")
//	public List<WebElement> data;
//	
//	@FindBy (xpath="//input[@id='empsearch_employee_name_empName']")
//	public WebElement EmpNamesrc;
//	/**
//	 * Can be access by clicking save Button in Add Employee page
//	 * Or by Clicking employee name in Employee information Page
//	 */
//	@FindBy (xpath="//div[@id='profile-pic']/h1")
//	public WebElement photoName;

	public ViewEmployeePageElements() {

		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public boolean isTableDisplayed() {
		return employeesTable.isDisplayed();
	}
	
	public List<Map<String, String>> getFirstNameFromTable(){
		List<Map<String,String>> uiName= new ArrayList<>();
		for(WebElement row: tableFirstName) {
			Map<String,String> storeUiNames= new LinkedHashMap<>();
			String tableName= row.getText();
			storeUiNames.put("emp_firstname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}
	public List<Map<String, String>> getLastNameFromTable(){
		List<Map<String,String>> uiName= new ArrayList<>();
		for(WebElement row: tableLastName) {
			Map<String,String> storeUiNames= new LinkedHashMap<>();
			String tableName= row.getText();
			storeUiNames.put("emp_lastname", tableName);
			uiName.add(storeUiNames);
		}
		return uiName;
	}
}
