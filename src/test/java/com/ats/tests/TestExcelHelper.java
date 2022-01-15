/**
 * 
 */
package com.ats.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ats.helper.ExcelHelper;
import com.ats.utils.CustomAssertion;

/**
 * @author suhail
 *
 */
public class TestExcelHelper {
	
	ExcelHelper excelHelper;
	String sheetName = "automationsheet";
	
	Logger logger = Logger.getLogger(TestExcelHelper.class.getName());
	
	@BeforeClass
	public void intialize() {
		String excelFilePath = System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx";
		logger.info("Excel file path : "+excelFilePath);
		excelHelper = new ExcelHelper(excelFilePath);
	}
	
	//@Test(priority=0)
	public void addNewSheet_Test() {		
		Boolean isSheetCreated = excelHelper.addSheet(sheetName);
		CustomAssertion.isEqual(true, isSheetCreated, "Sheet created");
	}

	@Test
	public void sheetAvailability_Test() {	
		Boolean isSheetPresent = excelHelper.isSheetExist(sheetName);
		CustomAssertion.isEqual(true, isSheetPresent, "Sheet available");
	}
	
	@Test(priority=1)
	public void addDataToCell_Test() {	
		Boolean isDataAdded = excelHelper.setCellData(sheetName, "Col1", 2, "hello ..");
		CustomAssertion.isEqual(true, isDataAdded, "Add data to cell");
	}
	
	@Test(priority=2)
	public void addDataToCellWithHyperLink_Test() {	
		Boolean isDataAddedWithUrl = excelHelper.setCellData(sheetName, "Col2", 2, "automationtestingstudio", "https://www.youtube.com/c/AutomationTestingStudio");
		CustomAssertion.isEqual(true, isDataAddedWithUrl, "Data added to cell hyperlink");
	}
	
	@Test(priority=3)
	public void addNewColumn_Test() {	
		Boolean isColumnAdded = excelHelper.addColumn(sheetName, "Col3");
		CustomAssertion.isEqual(true, isColumnAdded, "Add new column");
	}
	
	
	
	@Test(priority=5)
	public void getCellData_Test() {	
		String cellData = excelHelper.getCellData(sheetName, 1, 0);
		CustomAssertion.isEqual("", cellData, "Get cell data");
	}
	
	@Test(priority=6)
	public void getCellDataWithColumnName_Test() {	
		String cellData = excelHelper.getCellData(sheetName, "Col2", 1);
		CustomAssertion.isEqual("", cellData, "Get cell data with column name");
	}
	
	@Test(priority=7)
	public void getCellRowNumber_Test() {	
		int rowNum = excelHelper.getCellRowNum(sheetName, "Col2", "automationtestingstudio");
		CustomAssertion.isEqual(1, rowNum, "Row Number");
	}
	
	@Test(priority=8)
	public void getColumnCount_Test() {	
		int columnCount = excelHelper.getColumnCount(sheetName);
		CustomAssertion.isEqual(1, columnCount, "Column count");
	}
	
	@Test(priority=9)
	public void getRowCount_Test() {	
		int rowCount = excelHelper.getRowCount(sheetName);
		CustomAssertion.isEqual(1, rowCount, "Row count");
	}
	
	
	//@Test(priority=10)
	public void removeColumn_Test() {	
		Boolean isColumnRemoved = excelHelper.removeColumn(sheetName, 0);
		CustomAssertion.isEqual(true, isColumnRemoved, "Remove column");
	}
	
	
	//@Test(priority=11)
	public void removeSheet_Test() {	
		Boolean isSheetRemoved = excelHelper.removeSheet(sheetName);
		CustomAssertion.isEqual(true, isSheetRemoved, "Remove sheet");
	}
	
	
}
