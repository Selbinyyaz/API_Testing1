package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;



public class DashBoardPageElement extends CommonMethods {

	@FindBy(id = "welcome")
	public WebElement welcome;
	
	@FindBy(xpath ="//div[@id='branding']/a[1]/img")
	public WebElement logo;
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement Pim;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement empListPage;
	
	@FindBy(xpath = "//div[@class='menu']/ul/li")
	public List<WebElement> menu;

	@FindBy(xpath="//div[@class='menu']/ul/li")
	public List<WebElement> dashMenu;


	public DashBoardPageElement() {

		PageFactory.initElements(BaseClass.driver, this);
	}
	public void navigateToAddEmployee() {
		jsClick(Pim);
		jsClick(addEmployee);
	}
}
