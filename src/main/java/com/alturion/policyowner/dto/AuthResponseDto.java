package com.alturion.policyowner.dto;

public class AuthResponseDto {
	
	String token;
	
	public AuthResponseDto(String token) {
		super();
		this.token = token;
	}
	public String getToken() {
		return token;
	}
}
