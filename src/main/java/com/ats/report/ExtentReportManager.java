/**
 * 
 */
package com.ats.report;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author suhail
 *
 */
public class ExtentReportManager {
	
	static ExtentReports extentReports;
	final static String reportPath = System.getProperty("user.dir")+"/reports/testreport.html";
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	
	public synchronized static ExtentReports getReporter() {
		if(extentReports == null) {
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
			extentSparkReporter.config().setDocumentTitle("Title of the report");
			extentSparkReporter.config().setReportName("Report Name");
			extentSparkReporter.config().setTheme(Theme.STANDARD);
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
		}
		return extentReports;
	}
	
	public static synchronized ExtentTest getTest() {
		if(extentReports == null)
			startTest("testName", "desc");
		return extentTestMap.get((int)(long)(Thread.currentThread()).getId());
	}
	
	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = getReporter().createTest(testName,desc);
		extentTestMap.put((int)(long) (Thread.currentThread().getId()),test);
		return test;
	}

}
