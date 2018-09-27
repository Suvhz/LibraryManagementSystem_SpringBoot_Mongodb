package com.suvha.libraryManagementSystem.model;

import java.util.Date;

public class ErrorMessage {
	private Date timestamp;
	private String errorMessage;
	private String detail;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(Date timestamp, String errorMessage, String detail) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.detail = detail;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String requestedURL) {
		this.detail = requestedURL;
	}
	
}
