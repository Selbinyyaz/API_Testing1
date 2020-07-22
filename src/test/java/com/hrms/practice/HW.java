package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class HW {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

//hw get the resultset metadat store it in the arraylist and retrieve it from arraylist
// also get column type name get the table names	
@Test
	public void rsMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select emp_firstname, emp_lastname, emp_birthday, job_title_code\n" + 
				"from hs_hr_employees\n" + 
				"where job_title_code = 10 or job_title_code =35;");
		
		//get info about result table
		ResultSetMetaData rsMetadata =rs.getMetaData();
		String tableName =rsMetadata.getTableName(1);
		System.out.println(tableName);
		System.out.println("-----------------------------");
		
		// count column numbers
		int colNumbers=rsMetadata.getColumnCount();
		
		for (int i = 1; i < colNumbers; i++) {
			System.out.println(rsMetadata.getColumnName(i));
		}
		System.out.println("-----------------------------");
		
		List<String> arrData = new ArrayList<>();
//		List<String> lastName = new ArrayList<>();
//		List<String> birthday = new ArrayList<>();
//		List<String> JobtitleCode = new ArrayList<>();
		
		
		
		
		while(rs.next()) {
			arrData.add(rs.getString("emp_firstname"));
			arrData.add(rs.getString("emp_lastname"));
			arrData.add(rs.getString("emp_birthday"));
			arrData.add(rs.getString("job_title_code"));
		}
		
//		for (int i = 1; i < colNumbers; i++) {
//			//System.out.println(firstName.get(i)+lastName.get(i)+birthday.get(i)+JobtitleCode.get(i));
//			System.out.println(rsMetadata.getColumnName(i));
//			System.out.println(firstName.get(i));
//		}
		
//		for (int i = 1; i < firstName.size(); i++) {
//			String Firstname=firstName.get(i);
//			String Lastname=lastName.get(i);
//			String birthDay=birthday.get(i);
//			String jobtitleCode=JobtitleCode.get(i);
//			System.out.println(Firstname+"   "+Lastname+"   "+birthDay+"   "+jobtitleCode);
//		}  

		for (String string : arrData) {
			System.out.println(string + " ");
		}
		rs.close();
		st.close();
		conn.close();

	}
}
