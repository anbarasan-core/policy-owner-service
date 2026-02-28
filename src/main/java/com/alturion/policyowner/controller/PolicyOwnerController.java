package com.alturion.policyowner.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alturion.policyowner.common.ApiResponse;
import com.alturion.policyowner.dto.PolicyOwnerDTO;

@RestController
@RequestMapping("/api/policyowners")
public class PolicyOwnerController {
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<PolicyOwnerDTO>> createPolicyOwner(@RequestBody PolicyOwnerDTO policyOwnerDTO) {
		
		ApiResponse<PolicyOwnerDTO> apiResponse = new ApiResponse<PolicyOwnerDTO>(
				LocalDateTime.now(),
				201,
				"Policy Owner Created Successfully",
				policyOwnerDTO
				);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		}
	
	@GetMapping("/welcomeMessage")
	public String welcomeMessage() {
		return "Welcome Policy Owners!";
	}

}
