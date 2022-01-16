/**
 * 
 */
package com.ats.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import com.ats.helper.CustomAssertion;

import com.ats.utils.ExcelUtil;


/**
 * @author suhail
 *
 */
public class ExcelUtilTests {
	
	ExcelUtil excelUtil;
	String sheetName = "automationsheet";
	
	Logger logger = Logger.getLogger(ExcelUtilTests.class.getName());
	
	@BeforeClass
	public void intialize() {
		String excelFilePath = System.getProperty("user.dir")+"/src/test/resources/testdata.xlsx";
		logger.info("Excel file path : "+excelFilePath);
		excelUtil = new ExcelUtil(excelFilePath);
	}
	
	//@Test(priority=0)
	public void addNewSheet_Test() {		
		Boolean isSheetCreated = excelUtil.addSheet(sheetName);
		CustomAssertion.isEqual(true, isSheetCreated, "Sheet created");
	}

	@Test
	public void sheetAvailability_Test() {	
		Boolean isSheetPresent = excelUtil.isSheetExist(sheetName);
		CustomAssertion.isEqual(true, isSheetPresent, "Sheet available");
	}
	
	@Test(priority=1)
	public void addDataToCell_Test() {	
		Boolean isDataAdded = excelUtil.setCellData(sheetName, "Col1", 2, "hello ..");
		CustomAssertion.isEqual(true, isDataAdded, "Add data to cell");
	}
	
	@Test(priority=2)
	public void addDataToCellWithHyperLink_Test() {	
		Boolean isDataAddedWithUrl = excelUtil.setCellData(sheetName, "Col2", 2, "automationtestingstudio", "https://www.youtube.com/c/AutomationTestingStudio");
		CustomAssertion.isEqual(true, isDataAddedWithUrl, "Data added to cell hyperlink");
	}
	
	@Test(priority=3)
	public void addNewColumn_Test() {	
		Boolean isColumnAdded = excelUtil.addColumn(sheetName, "Col3");
		CustomAssertion.isEqual(true, isColumnAdded, "Add new column");
	}
	
	
	
	@Test(priority=5)
	public void getCellData_Test() {	
		String cellData = excelUtil.getCellData(sheetName, 1, 0);
		CustomAssertion.isEqual("", cellData, "Get cell data");
	}
	
	@Test(priority=6)
	public void getCellDataWithColumnName_Test() {	
		String cellData = excelUtil.getCellData(sheetName, "Col2", 1);
		CustomAssertion.isEqual("", cellData, "Get cell data with column name");
	}
	
	@Test(priority=7)
	public void getCellRowNumber_Test() {	
		int rowNum = excelUtil.getCellRowNum(sheetName, "Col2", "automationtestingstudio");
		CustomAssertion.isEqual(1, rowNum, "Row Number");
	}
	
	@Test(priority=8)
	public void getColumnCount_Test() {	
		int columnCount = excelUtil.getColumnCount(sheetName);
		CustomAssertion.isEqual(1, columnCount, "Column count");
	}
	
	@Test(priority=9)
	public void getRowCount_Test() {	
		int rowCount = excelUtil.getRowCount(sheetName);
		CustomAssertion.isEqual(1, rowCount, "Row count");
	}
	
	
	//@Test(priority=10)
	public void removeColumn_Test() {	
		Boolean isColumnRemoved = excelUtil.removeColumn(sheetName, 0);
		CustomAssertion.isEqual(true, isColumnRemoved, "Remove column");
	}
	
	
	//@Test(priority=11)
	public void removeSheet_Test() {	
		Boolean isSheetRemoved = excelUtil.removeSheet(sheetName);
		CustomAssertion.isEqual(true, isSheetRemoved, "Remove sheet");
	}
	
	
}
