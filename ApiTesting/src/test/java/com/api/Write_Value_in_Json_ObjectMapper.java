package com.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.Pojo.Datum;
import com.Pojo.Root;
import com.Pojo.Support;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Write_Value_in_Json_ObjectMapper {

	@Test
	public void write() throws StreamWriteException, DatabindException, IOException {
	
		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\ApiTesting\\src\\test\\resources\\Flights.json");
		
		ObjectMapper map = new ObjectMapper();
		
		 ArrayList<Datum> data = new ArrayList<Datum>();		
		 
		 Datum d1 = new Datum(111, "canada air", "canada", "222", "http//omr");
		 Datum d2 = new Datum(333, "usa air", "usa", "444", "http//ecr");
		 Datum d3 = new Datum(555, "eu air", "eu", "666", "http//guindy");
		 Datum d4 = new Datum(777, "india air", "india", "888", "http//chennai");
		 Datum d5 = new Datum(999, "china air", "china", "000", "http//trichy");
		 Datum d6 = new Datum(123, "russia air", "russia", "321", "http//mayavaram");
		 
		 data.add(d6);
		 data.add(d5);
		 data.add(d4);
		 data.add(d3);
		 data.add(d2);
		 data.add(d1);
		 
		 Support s = new Support("http//world", "wow");
		 Root r = new Root(1,2,3,4,data,s);
		 
		 map.writeValue(f, r);
	}
	
	// json file to write
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
// ===============================================================================================================
	
	// output of json file to write
	
	/*
	{
	"page": 1,
	"per_page": 2,
	"total": 3,
	"total_pages": 4,
	"data": [
		{
			"id": 123,
			"flightName": "russia air",
			"Country": "russia",
			"Destinations": "321",
			"URL": "http//mayavaram"
		},
		{
			"id": 999,
			"flightName": "china air",
			"Country": "china",
			"Destinations": "000",
			"URL": "http//trichy"
		},
		{
			"id": 777,
			"flightName": "india air",
			"Country": "india",
			"Destinations": "888",
			"URL": "http//chennai"
		},
		{
			"id": 555,
			"flightName": "eu air",
			"Country": "eu",
			"Destinations": "666",
			"URL": "http//guindy"
		},
		{
			"id": 333,
			"flightName": "usa air",
			"Country": "usa",
			"Destinations": "444",
			"URL": "http//ecr"
		},
		{
			"id": 111,
			"flightName": "canada air",
			"Country": "canada",
			"Destinations": "222",
			"URL": "http//omr"
		}
	],
	"support": {
		"url": "http//world",
		"text": "wow"
	}
}

	}
	 */
	
	
}
