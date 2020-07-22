package com.hrms.API.steps.practice;

public class HardcodedConstants {
	
	public static String updateCreatedEmpBody() {
		
		 String updateBody="{\n" + 
				"  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\n" + 
				"  \"emp_firstname\": \"syntaxUpdatedFirstName\",\n" + 
				"  \"emp_lastname\": \"syntaxUpdatedLastName\",\n" + 
				"  \"emp_middle_name\": \"syntaxUpdatedMiddleName\",\n" + 
				"  \"emp_gender\": \"F\",\n" + 
				"  \"emp_birthday\": \"2000-07-11\",\n" + 
				"  \"emp_status\": \"Employee\",\n" + 
				"  \"emp_job_title\": \"Cloud Consultant\"\n" + 
				"}";
		return updateBody;
	}

}
