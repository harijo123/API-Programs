package com.api;

import org.testng.annotations.Test;

import com.baseclass.Baseclass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasciAuthentication extends Baseclass {

//	 public static void main(String[] args) {
//
//	Sample r = new Sample();
//	 r.login();
//	 } public void login() {
//
//	 RequestSpecification req;
//	
//	 //1.header
//	 req = io.restassured.RestAssured.given().header("accept","application/json");
//	
//	 // 2.basic auth
//	 req =
//	 req.auth().preemptive().basic("hariijack.97@gmail.com","Niralyaraja@735");
//	
//	 //3. req type
//	 Response response =
//	 req.post("https://omrbranch.com/api/postmanBasicAuthLogin");
//	
//	 //4.status code
//	
//	 int statusCode = response.statusCode();
//	 System.out.println(statusCode);
//	
//	 String asString = response.asString();
//	 System.out.println(asString);
//	 }

	@Test
	public void login() {
		addHeader("accept", "application/json");

		addBasicAuth("hariijack.97@gmail.com", "Niralyaraja@735");

		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

//		String resAsString = getResAsString(response);
//		System.out.println(resAsString);
		
		Response prettyPeek = response.prettyPeek();
		System.out.println(prettyPeek);

//		String prettyPrint = response.prettyPrint();
//		System.out.println(prettyPrint);
	}
	
	
	
}
