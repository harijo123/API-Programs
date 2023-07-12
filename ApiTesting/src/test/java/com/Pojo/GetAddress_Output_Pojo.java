package com.Pojo;

import java.util.ArrayList;

public class GetAddress_Output_Pojo {
	 private int status;
	    private String message;
	    private ArrayList<Get> data;
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public ArrayList<Get> getData() {
			return data;
		}
		public void setData(ArrayList<Get> data) {
			this.data = data;
		}
}
