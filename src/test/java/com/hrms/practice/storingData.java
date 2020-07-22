package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class storingData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	//@Test
	public void getAndStoreData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select id, name, country_code from ohrm_location");

		List<Map<String, String>> ListofData = new ArrayList<>();
		
		Map<String, String> mapData;
		
		while (rs.next()) {
			mapData = new LinkedHashMap<>();// we use linkedHashmap because inserted order
			// initializing map after each iteration so †hat out data do not get overwritten 
			// if we initialize outside while loop that it create 1 and repeated same
			
			mapData.put("Location id", rs.getObject("id").toString());//storing our first column into
			//System.out.println(mapData);
			mapData.put("Office name", rs.getObject("name").toString());
			//System.out.println(mapData);
			mapData.put("Country code", rs.getObject("country_code").toString());
			//System.out.println(mapData);
			ListofData.add(mapData);// storing our map inside our list
		}
		System.out.println(ListofData);

		rs.close();
		st.close();
		conn.close();

	}
	//@Test
	public void retrieveAndStoreDataEnhanced() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select * from ohrm_job_title");
		
		ResultSetMetaData rsMetaData = rs.getMetaData();
		
		List<Map<String, String>> ListofData = new ArrayList<>();
		
		Map<String, String> mapData;
		
		while(rs.next()) {
			mapData= new LinkedHashMap<>();
			
			for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
				//storing all the data
				mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			} 
			//store it in map list
			ListofData.add(mapData);
		}
		System.out.println(ListofData);
		
		rs.close();
		st.close();
		conn.close();
		
	}
	
	@Test
	public void getAndstoreData1() throws SQLException {
		
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select * from ohrm_nationality;");

		ResultSetMetaData rsMetaData = rs.getMetaData();
		
		System.out.println(rsMetaData.getColumnCount());

		List<Map<String, String>> ListofData = new ArrayList<>();

		Map<String, String> mapData;
		
		while(rs.next()) {
			
			mapData= new LinkedHashMap<>();
			
			for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
				System.out.println(rsMetaData.getColumnName(i));
				
				//mapData.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			} 
		
		//	ListofData.add(mapData);
			
		}
	//	System.out.println(ListofData);
//		for (Map<String, String> map : ListofData) {
//			System.out.println(map);
//		}
	}
}
