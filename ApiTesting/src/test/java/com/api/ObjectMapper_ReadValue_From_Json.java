package com.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.Pojo.Datum;
import com.Pojo.Root;
import com.Pojo.Support;
import com.baseclass.Baseclass;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class ObjectMapper_ReadValue_From_Json extends Baseclass {

	@Test
	public void ReadJson() throws StreamReadException, DatabindException, IOException {
		File f = new File(getProjectPath()+"\\src\\test\\resources\\ListFlights.json");
		
		ObjectMapper obj = new ObjectMapper();
		
		Root r = obj.readValue(f, Root.class);
		
		int page = r.getPage();
		System.out.println(page);
		
		int per_page = r.getPer_page();
		System.out.println(per_page);
		
		int total = r.getTotal();
		System.out.println(total);
		
		int total_pages = r.getTotal_pages();
		System.out.println(total_pages+"\n");
		
		ArrayList<Datum> data = r.getData();
		for (Datum datum : data) {
			System.out.println(datum.getId());
			System.out.println(datum.getFlightName());
			System.out.println(datum.getCountry());
			System.out.println(datum.getDestinations());
			System.out.println(datum.getuRL()+"\n");
			
		}
		
		Support support = r.getSupport();
		System.out.println(support.getText());
		System.out.println(support.getUrl());

	}
	
	//json file for above program
	
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
