package com.Pojo;

import java.util.ArrayList;

public class Get_StateList_Output_Pojo {
	  public int status;
	    public String message;
	    public ArrayList<StateList> data;
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
		public ArrayList<StateList> getData() {
			return data;
		}
		public void setData(ArrayList<StateList> data) {
			this.data = data;
		}
	    
}
