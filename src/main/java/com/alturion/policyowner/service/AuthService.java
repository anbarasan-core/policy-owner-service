package com.alturion.policyowner.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.alturion.policyowner.security.jwt.JwtUtil;

@Service
public class AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	private final JwtUtil jwtUtil;
	private final AuthenticationManager authenticationManager;
	
	public AuthService(JwtUtil jwtUtil,AuthenticationManager authenticationManager) {
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}
	
	public String login(String username,String password) {
		
		logger.info("Executing AuthService::login");
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		logger.info("User Authenticated. Proceeding to Generate Token");
		return jwtUtil.generateToken(username);
	}

}
