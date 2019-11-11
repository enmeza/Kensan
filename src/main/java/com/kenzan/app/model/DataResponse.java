package com.kenzan.app.model;

import java.io.Serializable;

public class DataResponse implements Serializable {

	private static final long serialVersionUID = 7076161276649384625L;
	private Boolean success;
	private String message;
	
	public Boolean getSuccess() {
		return success;
	}
	
	public DataResponse setSuccess(Boolean success) {
		this.success = success;
		return this;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public DataResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	
	
}
