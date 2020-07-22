package com.hrms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;

	public static void openExcel(String filePath) {

		try {
			FileInputStream fileInput = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileInput);
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();

	}

	public static int colsCount(int row) {
		return sheet.getRow(row).getLastCellNum();

	}

	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();

	}
	
	public static Object[][] excelIntoArray(String filePath, String sheetName){
		
		
		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int cols = colsCount(0);

		Object[][] data = new Object[rows - 1][cols];

		// iterating rows
		for (int i = 1; i < rows; i++) {

			// iterating cols
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = cellData(i, j);
			}
		}

		return data;
	}

	//HW Create a method that will return a List of Maps
	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> excelMap;

		for (int row = 1; row < rowCount(); row++) {
			excelMap = new LinkedHashMap<>();

			for (int c = 0; c < colsCount(row); c++) {
				excelMap.put(cellData(0, c), cellData(row, c));
			}
			list.add(excelMap);
		}

		return list;
	}

}
