package com.api;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonArray_ReadValue_From_Json {

	//Here im read the value of data key
	@Test
	public void ReadJson_JsonObject() throws IOException, ParseException {
	
	java.io.FileReader f = new java.io.FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ListFlights.json");
	
	JSONParser json = new JSONParser();
	
	Object parse = json.parse(f);
	
	JSONObject Jobj = (JSONObject) parse;
	
	Object dataObj = Jobj.get("data");
	
	JSONArray JarrayObj = (JSONArray) dataObj;
	
	for (int i = 0; i < JarrayObj.size(); i++) {
		
		Object arrayGet = JarrayObj.get(i);
		JSONObject JobjInner = (JSONObject) arrayGet;
		
		System.out.println(JobjInner.get("id"));
		
		Object flightName = JobjInner.get("flightName");
		System.out.println(flightName);
		
		Object Country = JobjInner.get("Country");
		System.out.println(Country);
		
		Object Destinations = JobjInner.get("Destinations");
		System.out.println(Destinations);
		
		Object URL = JobjInner.get("URL");
		System.out.println(URL+"\n");
	
	}}
// json file for above program
	
	/*
	 {
    "page": 1,
    "per_page": 6,
    "total": 2948,
    "total_pages": 492,
    "data": [
        {
            "id": 3,
            "flightName": "Indian AirLines",
            "Country": "India",
            "Destinations": "60",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Air_India"
        },
        {
            "id": 18,
            "flightName": "AirIndia",
            "Country": "India",
            "Destinations": "87",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Air_India"
        },
        {
            "id": 22,
            "flightName": "AirIndia",
            "Country": "India",
            "Destinations": "87",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Air_India"
        },
        {
            "id": 32,
            "flightName": "AirIndia",
            "Country": "India",
            "Destinations": "87",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Air_India"
        },
        {
            "id": 33,
            "flightName": "AirIndia",
            "Country": "India",
            "Destinations": "20",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Air_India"
        },
        {
            "id": 36,
            "flightName": "Srilankan AriLines",
            "Country": "SriLanka",
            "Destinations": "56",
            "URL": "https:\/\/en.wikipedia.org\/wiki\/Sri_Lanka"
        }
    ],
    "support": {
        "url": "https:\/\/omrbranch.com",
        "text": "For Joining Automation Course, Please Contact-Velmurugan 9944152058"
    }
}
	 
	 */

}
	

