/**
 * 
 */
package com.ats.helper;

/**
 * @author suhail
 *
 */
public class DatabaseQueries {
	
	public String queryForDataRetrievalFromTable(String tableName, String columnName, String columnValue) {
		return "Select * from "+tableName+" where "+columnName+" = "+columnValue+"";
	}

}
