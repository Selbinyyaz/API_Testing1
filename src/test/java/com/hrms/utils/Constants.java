package com.hrms.utils;

public class Constants {
	
	
	
	public static final String Configuration_FilePath=System.getProperty("user.dir")+"/src/test/resources/configs/configuration.properties";
	
	public static final int IMPLICIT_WAIT_TIME=15;//don't do more than 30
	
	public static final int EXPILICIT_WAIT_TIME=30;
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/testdata/TestExcel.xlsx";
	
	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"/target/html-report/HRMS.html";

	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/screenshot/";
}
