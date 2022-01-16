/**
 * 
 */
package com.ats.helper;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ats.report.ExtentReportManager;
import com.aventstack.extentreports.Status;

/**
 * @author suhail
 *
 */
public class Log implements ITestListener {
	
	private static Logger log = Logger.getLogger(Log.class.getName());
	
	public static void info(String message) {
		log.info(message);
		ExtentReportManager.getTest().log(Status.INFO, message);
	}
	
	public static void warn(String message) {
		log.warn(message);
		ExtentReportManager.getTest().log(Status.WARNING, message);
	}
	
	public static void pass(String message) {
		log.info(message);
		ExtentReportManager.getTest().log(Status.PASS, message);
	}
	
	public static void error(String message) {
		log.error(message);
		ExtentReportManager.getTest().log(Status.FAIL, message);
		Assert.fail();
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(result.getName(), result.getMethod().getDescription()).assignAuthor("Author Name");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.getReporter().flush();
	}
	
	

}
