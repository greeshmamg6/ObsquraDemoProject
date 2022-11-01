package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

import com.constants.AutomationConstants;

public class ExcelUtil {
	PropertyUtil properties= new PropertyUtil();
	public static final String currentDir  = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/main/resources/";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	String fileName=properties.getProperty("fileName");

	/**
	* This method is to read the excel file
	* @param fileName
	* @param sheetName
	* @throws IOException
	*/
	public ExcelUtil(String fileName, String sheetName)throws IOException {
		try {
		String excelPath = filePath+fileName;
		   workbook = new XSSFWorkbook(excelPath);
		   sheet = (XSSFSheet) workbook.getSheet(sheetName);
		}catch(Exception e) {
		e.printStackTrace();
		}
		}

	/**
	* method to get rowsCount
	*/
	public static int getRowCount() {
	int rowCount = 0;
	try {
	rowCount = sheet.getPhysicalNumberOfRows();
	}
	catch (Exception e) {
		System.out.println(AutomationConstants.EXCEPTION_MSG + e.getMessage());
		System.out.println(AutomationConstants.CAUSE + e.getCause());
	}
	return rowCount;
	}
	/**
	* method to get columnCount
	*/
	public static int getColCount() {
	int colCount = 0;
	try {
	colCount = sheet.getRow(0).getLastCellNum();
	}catch (Exception e) {
	e.printStackTrace();
	}
	return colCount;
	}

	/**
	* method to get cell data (String)
	*/
	public String getCellDataString(int rowNum, int colNum) {
	String cellValue = null;
	try {
	cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	catch (Exception e) {
	e.printStackTrace();
	}
	return cellValue;
	}
	/**
	* This method is to read string data from excel
	* @param fileName
	* @param sheetname
	* @param rowNum
	* @param colNum
	* @return
	* @throws IOException
	*/
	public  String readStringData(String fileName, String sheetname, int rowNum,int colNum) throws IOException
	{
	String excelPath = filePath+fileName;

	workbook=new XSSFWorkbook(excelPath);
	sheet=workbook.getSheet(sheetname);
	Row row=sheet.getRow(rowNum);
	Cell c=row.getCell(colNum);

	return c.getStringCellValue();
	}

	/**
	* This method is read Integerdata from excel
	* @param fileName
	* @param sheetname
	* @param rowNum
	* @param colNum
	* @return
	* @throws IOException
	*/
	public static int readIntegerData(String fileName,String sheetname, int rowNum,int colNum ) throws IOException
	{
	String excelPath = filePath+fileName;
	workbook=new XSSFWorkbook(excelPath);
	sheet=workbook.getSheet(sheetname);
	Row row=sheet.getRow(rowNum);
	Cell c=row.getCell(colNum);
	int a=(int) c.getNumericCellValue();
	return a;
	}
}


