/**
 * 
 */
package com.ats.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author suhail
 *
 */
public class PropertiesFileUtil {
	
	Logger logger = Logger.getLogger(PropertiesFileUtil.class.getName());
	public Properties props;
	String filePath = System.getProperty("user.dir")+"/src/test/resources/sit.properties";
	
	public PropertiesFileUtil() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(filePath));
			props = new Properties();
			props.load(fis);
			fis.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	
	public String getValue(String key) {
		logger.info("Key is : "+key);
		logger.info("Value for key "+key+" is "+props.getProperty(key));
		return props.getProperty(key);
	}
	
	public void setProperty(String key, String value) {
		OutputStream os = null;
		try {
			props.setProperty(key, value);
			os = new FileOutputStream(filePath);
			props.store(os, "");
			os.close();
		} catch (IOException e) {
			
		} 
		
		
	}

}
