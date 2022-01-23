/**
 * 
 */
package com.ats.api;

import java.util.Map;

import com.ats.pojos.RootPojo;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author suhail
 *
 */
public class APIRunnerUtil {

	public Response postRequest(String endpoint, String requestBody){
		RequestSpecification request = RestAssured.given();
		request.body(requestBody);
		Response response = request.post(endpoint);
		return response;
	}
	
	public Response postRequest(String endpoint, String requestBody, Map<String,String> headers){
		RequestSpecification request = RestAssured.given();
		request.headers(headers);
		request.body(requestBody);
		Response response = request.post(endpoint);
		return response;
	}
	
	public Response postRequest(String endpoint, RootPojo requestBody, Headers headers){
		RequestSpecification request = RestAssured.given();
		request.headers(headers);
		request.body(requestBody);
		Response response = request.post(endpoint);
		return response;
	}
	
	public Response getRequest(String url) {
		return RestAssured.given()
						  .get(url);
	}
	
	
	public Response getRequest(String url, Headers headers) {
		return RestAssured.given()
						  		.headers(headers)
						  					.get(url);
	}
	
	public Response getRequest(String url, Map<String,String> headers) {
		return RestAssured.given()
						  		.headers(headers)
						  					.get(url);
	}
	
	public Response getRequest(String url, Map<String,String> headers, Map<String,String> queryParams) {
		return RestAssured.given()
						  		.headers(headers)
						  				.queryParams(queryParams)
						  					.get(url);
	}
	
	
	
}
