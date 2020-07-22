package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportPage extends CommonMethods{

	@FindBy(id="menu_pim_viewPimModule")
	public WebElement Pim;
	
	@FindBy(id="menu_core_viewDefinedPredefinedReports")
	public WebElement Report;
	
	@FindBy(id="btnAdd")
	public WebElement addBtn;
	
	@FindBy(id="report_report_name")
	public WebElement reportName;
	
	@FindBy(xpath = "//select[@id='report_criteria_list']")
	public WebElement Criteria;
	
	@FindBy(id="report_include_comparision")
	public WebElement CriteriaInclude;
	
	@FindBy(linkText = "Display Field Groups")
	public WebElement Groups;
	
	@FindBy(id="report_display_field_list")
	public WebElement fields;
	
	@FindBy(id="btnAddDisplayField")
	public WebElement add;
	
	@FindBy(id="display_group_1")
	public WebElement checkBox;
	
	
	public ReportPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}
