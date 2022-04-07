package com.javaexpress.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErrorDetails {
	
	@JsonFormat(shape = Shape.STRING,pattern = "dd-mm-yyyy   hh:mm:ss")
	private LocalDateTime timestamp; //current timestamp
	private String message; //either internal or client or validation
	private List<String> details; //to hold my error message
	public ErrorDetails(LocalDateTime timestamp, String message, List<String> details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
 	
 
}
