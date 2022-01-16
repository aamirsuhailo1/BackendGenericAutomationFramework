/**
 * 
 */
package com.ats.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author suhail
 *
 */
public class DatabaseUtil {
	
	static Logger logger = Logger.getLogger(DatabaseUtil.class.getName());
	
	public static PropertiesFileUtil propertiesFileUtil = new PropertiesFileUtil();
	private static Connection con;
	private static String url = propertiesFileUtil.getValue("jdbc.url");
	private static String username = propertiesFileUtil.getValue("jdbc.username");
	private static final String password = propertiesFileUtil.getValue("jdbc.password");
	
	/**
	 * 
	 * @return
	 */
	public static Connection loadDriver() {
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			logger.error(e);
		}
		return con;
	}
	
	/**
	 * 
	 * @param query
	 * @return
	 */
	public static ResultSet getResultSet(String query) {	
		ResultSet rs = null;
		try {
			Connection con = loadDriver();	
			PreparedStatement st = con.prepareStatement(query);
			rs=st.executeQuery();
		} catch (SQLException e) {
			logger.error(e);
		}
		return rs;
	}
	
	/**
	 * 
	 * @param query
	 */
	public static void runQuery(String query) {	
		try {
			Connection con = loadDriver();	
			PreparedStatement st = con.prepareStatement(query);
			st.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
		}
	}
	
	

}
