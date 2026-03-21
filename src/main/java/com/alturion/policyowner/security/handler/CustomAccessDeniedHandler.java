package com.alturion.policyowner.security.handler;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
	
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json");
		
		String jsonResponse = "{"
	            + "\"timestamp\": \"" + LocalDateTime.now() + "\","
	            + "\"status\": 403,"
	            + "\"message\": \"Forbidden: " + accessDeniedException.getMessage() + "\","
	            + "\"data\": null"
	            + "}";
		response.getWriter().write(jsonResponse);
	}

}
