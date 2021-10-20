package com.mindtree.FlightApp.response;

public class FlightAppResponse {
	String message;
	int code;
	public FlightAppResponse(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}
	public FlightAppResponse(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
