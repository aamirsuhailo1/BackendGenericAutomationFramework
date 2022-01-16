/**
 * 
 */
package com.ats.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ats.helper.CustomAssertion;
import com.ats.report.ExtentReportManager;
import com.ats.utils.PropertiesFileUtil;
import com.aventstack.extentreports.Status;

/**
 * @author suhail
 *
 */
public class PropertiesFileUtilTests {
	
	PropertiesFileUtil propertiesFileUtil;
	
	@BeforeClass
	public void setup() {
		propertiesFileUtil = new PropertiesFileUtil();
	}
	
	@Test
	public void setValue_Test(){
		propertiesFileUtil.setProperty("env", "sit");
		ExtentReportManager.getTest().log(Status.PASS, "Value set successfully");
	}
	
	@Test
	public void getValue_Test() {
		String val = propertiesFileUtil.getValue("country");
		CustomAssertion.isEqual("india", val, "Property key env");
	}
	

}
