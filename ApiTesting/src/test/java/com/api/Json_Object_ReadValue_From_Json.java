package com.api;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;

import io.restassured.internal.support.FileReader;

public class Json_Object_ReadValue_From_Json {

	//Here im read the value of support key
	@Test
	public void ReadJson_JsonObject() throws IOException, ParseException {
	
	java.io.FileReader f = new java.io.FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ListFlights.json");
	
	JSONParser json = new JSONParser();
	
	Object parse = json.parse(f);
	
	JSONObject Jobj = (JSONObject) parse;
	
	Object supportObj = Jobj.get("support");
	
	JSONObject Obj = (JSONObject) supportObj;
	
	
		Object url = Obj.get("url");
		System.out.println(url);
		
		Object text = Obj.get("text");
		System.out.println(text);
		
	}		
	
	//json file for above program
	/*
	 {
    "page": 1,
    "per_page": 6,
    "total": 2948,
    "total_pages": 492,
    "support": {
        "url": "https:\/\/omrbranch.com",
        "text": "For Joining Automation Course, Please Contact-Velmurugan 9944152058"
    }
}
	 */

	
}
