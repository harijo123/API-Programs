package com.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	static RequestSpecification reqSpec;
	static Response response;

	public static void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void addMultipleHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);

	}
	
	public static void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public static void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public static void addBody(Object body) {
		reqSpec = reqSpec.body(body);

	}

	public static Response addReqType(String reqType, String endPoint) {
		switch (reqType.toUpperCase()) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;
		case "PATCH":
			response = reqSpec.log().all().patch(endPoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}

	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public static String getResAsString(Response response) {
		String asString = response.asString();
		return asString;

	}
	
//	public static String getResAsPrettyString() {
//		String asPrettyString = response.asPrettyString();
//		return asPrettyString;	
//
//	}

	public static void addBasicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}

	//to get path
	public static String getProjectPath() {
	String path = System.getProperty("user.dir");
	return path;

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
