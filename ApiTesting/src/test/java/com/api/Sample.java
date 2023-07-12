package com.api;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pojo.AddUserAddress_Input_Pojo;
import com.Pojo.AddUserAddress_Input_Pojo;
import com.Pojo.AddUserAddress_Output_Pojo;
import com.Pojo.CityList;
import com.Pojo.DeleteAddress_Input_Pojo;
import com.Pojo.DeleteAddress_Output_Pojo;
import com.Pojo.GetAddress_Output_Pojo;
import com.Pojo.Get_CityList_Input_Pojo;
import com.Pojo.Get_CityList_Output_Pojo;
import com.Pojo.Get_StateList_Output_Pojo;
import com.Pojo.Login_Output_Pojo;
import com.Pojo.StateList;
import com.Pojo.UpdateUserAddress_Input_Pojo;
import com.Pojo.UpdateUserAddress_Output_Pojo;
import com.baseclass.Baseclass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Sample extends Baseclass {
	String logtoken;
	String addressId;
	String stateIdText;
	int stateId;
	int cityId;

	// Authentication
	@Test(priority = 1)
	public void login() {
		// 1.header
		addHeader("accept", "application/json");

		// 2.Basic Authentication
		addBasicAuth("hariijack.97@gmail.com", "Niralyaraja@735");

		// 3.req type
		Response response = addReqType("post", "https://omrbranch.com/api/postmanBasicAuthLogin");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(first_name);
		Assert.assertEquals(first_name, "Hariharan", "verify first name");
	}

	// StateList
	@Test(priority = 2)
	public void getStateList() {
		// 1.header
		addHeader("accept", "application/json");

		// 3.req type
		Response response = addReqType("get", "https://omrbranch.com/api/stateList");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		Get_StateList_Output_Pojo getStateList_Output = response.as(Get_StateList_Output_Pojo.class);

		// 6. find the state id for Tamil Nadu
		ArrayList<StateList> statelist = getStateList_Output.getData();

		for (StateList stateList2 : statelist) {

			String statename = stateList2.getName();
			if (statename.equals("Tamil Nadu")) {
				stateId = stateList2.getId();
				stateIdText = String.valueOf(stateId);
				System.out.println("Tamil Nadu Id : " + stateId);
				break;
			}
		}

	}

	// city List
	@Test(priority = 3)
	public void getCityList() {

		// 1.Add headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);

		Headers headers = new Headers(listHeader);
		addMultipleHeaders(headers);

		// 2. Req body (payload)
		Get_CityList_Input_Pojo getCityList_Input = new Get_CityList_Input_Pojo(stateIdText);
		addBody(getCityList_Input);

		// 3.req type
		Response response = addReqType("post", "https://omrbranch.com/api/cityList");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		Get_CityList_Output_Pojo getCityList_Output = response.as(Get_CityList_Output_Pojo.class);

		// find city id by city name
		ArrayList<CityList> cityList = getCityList_Output.getData();
		for (CityList cityList2 : cityList) {
			String cityName = cityList2.getName();
			if (cityName.equals("Mayiladuthurai")) {
				cityId = cityList2.getId();
				System.out.println("Mayiladuthurai Id : " + cityId);
				break;

			}

		}

	}

	// POST (add address)
	@Test(priority = 4)
	public void addUserAddress() {
		// 1.Add headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addMultipleHeaders(headers);

		// 2.add user address [Req body (payload)]
		AddUserAddress_Input_Pojo addaddress_input = new AddUserAddress_Input_Pojo("Hariharan", "N", "7200288063",
				"No.2,", stateId, cityId, 101, "609001", " Indhra gandhi street, Ponni Nagar, srinivasapuram ", "home");
		addBody(addaddress_input);

		// 3.req type
		Response response = addReqType("POST", "https://omrbranch.com/api/addUserAddress");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		AddUserAddress_Output_Pojo addAddress_Output = response.as(AddUserAddress_Output_Pojo.class);
		String message = addAddress_Output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address added successfully", "verify address");

		int address_id = addAddress_Output.getAddress_id();
		addressId = String.valueOf(address_id);

	}

	// PUT (update address)
	@Test(priority = 5)
	public void UpdateAddress() {
		// 1.Add headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addMultipleHeaders(headers);

		// 2. Req body (payload)
		UpdateUserAddress_Input_Pojo updateAddress_Input = new UpdateUserAddress_Input_Pojo(addressId, "Priya",
				"Gomathi", "9942192570", "No.10,", stateId, 4196, 101, "604201", " Green garden", "HOME");
		addBody(updateAddress_Input);

		// 3.req type
		Response response = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		UpdateUserAddress_Output_Pojo updateAddress_Output = response.as(UpdateUserAddress_Output_Pojo.class);
		String message = updateAddress_Output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully", "verify address");

	}

	// GET
	@Test(priority = 6)
	public void getAddress() {

		// 1.Add headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		listHeader.add(h1);
		listHeader.add(h2);

		Headers headers = new Headers(listHeader);
		addMultipleHeaders(headers);

		// 3.req type
		Response response = addReqType("get", "https://omrbranch.com/api/getUserAddress");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		GetAddress_Output_Pojo getAddress_Output = response.as(GetAddress_Output_Pojo.class);
		String message = getAddress_Output.getMessage();
		System.out.println("First name: " + getAddress_Output.getData().get(1).getFirst_name());
		System.out.println(message);
		Assert.assertEquals(message, "OK", "verify OK");

	}

	// DELETE
	@Test(priority = 7)
	public void deleteAddress() {
		// 1.Add headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addMultipleHeaders(headers);

		// 2. Req body (payload)
		DeleteAddress_Input_Pojo deleteAddress_Input = new DeleteAddress_Input_Pojo(addressId);
		addBody(deleteAddress_Input);

		// 3.req type
		Response response = addReqType("delete", "https://omrbranch.com/api/deleteAddress");

		// 4.status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, " verify status code");

		// 5.Deserialization (read)
		DeleteAddress_Output_Pojo deleteAddress_Output = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddress_Output.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully", "verify delete message");

	}

}
