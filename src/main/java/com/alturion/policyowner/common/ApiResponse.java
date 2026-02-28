package com.alturion.policyowner.common;

import java.time.LocalDateTime;

public class ApiResponse<T> {
	
	private LocalDateTime timestamp;
	private int status;
	private String message;
	private T data;
	
	// No-args constructor (for Jackson)
    public ApiResponse() {
    }
	
	// All-args constructor (for manual creation)
	public ApiResponse(LocalDateTime timestamp, int status, String message, T data) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.data = data;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


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


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}
	
	

}
