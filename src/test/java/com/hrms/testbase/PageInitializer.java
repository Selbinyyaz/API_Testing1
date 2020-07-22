package com.hrms.testbase;


import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashBoardPageElement;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportPage;
import com.hrms.pages.ViewEmployeePageElements;


public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashBoardPageElement dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
	public static ReportPage report;
	public static ViewEmployeePageElements viewEmp;
	
	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashBoardPageElement();
		addEmp = new AddEmployeePageElements();
		pdetails = new PersonalDetailsPageElements();
		report=new ReportPage();
		viewEmp=new ViewEmployeePageElements();
		

	}

}
