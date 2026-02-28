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
import com.alturion.policyowner.service.PolicyOwnerService;

@RestController
@RequestMapping("/api/policyowners")
public class PolicyOwnerController {
	
	private final PolicyOwnerService policyOwnerService;
	
	public PolicyOwnerController(PolicyOwnerService policyOwnerService) {
		this.policyOwnerService = policyOwnerService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<PolicyOwnerDTO>> ownerCreation(@RequestBody PolicyOwnerDTO policyOwnerDTO) {
		
		PolicyOwnerDTO createdOwner = policyOwnerService.createPolicyOwner(policyOwnerDTO);
		
		ApiResponse<PolicyOwnerDTO> apiResponse = new ApiResponse<PolicyOwnerDTO>(
				LocalDateTime.now(),
				HttpStatus.CREATED.value(),
				"Policy Owner Created Successfully",
				createdOwner
				);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		}
	
	@GetMapping("/welcomeMessage")
	public String welcomeMessage() {
		return "Welcome Policy Owners!";
	}

}
