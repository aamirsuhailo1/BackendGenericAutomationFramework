/**
 * 
 */
package com.ats.helper;

import org.testng.Assert;

/**
 * @author suhail
 *
 */
public class CustomAssertion {
	
	public static void isEqual(String expected, String actual, String fieldName) {
		try {
			Assert.assertEquals(expected, actual);
			Log.pass("Actual value of "+fieldName+" is "+actual+" and expected value is "+expected);
		} catch (AssertionError e) {
			Log.error("Actual value of "+fieldName+" is "+actual+" but expected value is "+expected);
		}
	}
	
	public static void isEqual(int expected, int actual, String fieldName) {
		try {
			Assert.assertEquals(expected, actual);
			Log.pass("Actual value of "+fieldName+" is "+actual+" and expected value is "+expected);
		} catch (AssertionError e) {
			Log.error("Actual value of "+fieldName+" is "+actual+" but expected value is "+expected);
		}
	}
	
	public static void isEqual(Boolean expected, Boolean actual, String fieldName) {
		try {
			Assert.assertEquals(expected, actual);
			Log.pass("Actual value of "+fieldName+" is "+actual+" and expected value is "+expected);
		} catch (AssertionError e) {
			Log.error("Actual value of "+fieldName+" is "+actual+" but expected value is "+expected);
		}
	}
	
	
	public static void isNotNull(String value, String fieldName) {
		try {
			Assert.assertNotNull(value);
			Log.pass("Value of "+fieldName+" is not null");
		} catch (AssertionError e) {
			Log.error("Value of "+fieldName+" is  null");
		}
	}
	
	
	
	

}
