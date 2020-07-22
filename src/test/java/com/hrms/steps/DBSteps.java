package com.hrms.steps;

import java.util.List;
import java.util.Map;

import com.hrms.utils.DBUtils;

import io.cucumber.java.en.When;

public class DBSteps {

	public static List<Map<String, String>> dbData;

	@When("get data from DB")
	public void get_data_from_DB() {
		String sqlQuery = "select emp_lastname from hs_hr_employees where employee_id= 14688";
		dbData=DBUtils.storeDataFromDB(sqlQuery);
	}
}
