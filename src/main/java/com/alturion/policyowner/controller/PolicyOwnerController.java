package com.alturion.policyowner.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alturion.policyowner.common.ApiResponse;
import com.alturion.policyowner.dto.OwnerAgentMappingRequestDto;
import com.alturion.policyowner.dto.OwnerAgentMappingResponseDto;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;
import com.alturion.policyowner.service.PolicyOwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policyowners")
public class PolicyOwnerController {
	
	private final PolicyOwnerService policyOwnerService;
	
	public PolicyOwnerController(PolicyOwnerService policyOwnerService) {
		this.policyOwnerService = policyOwnerService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<PolicyOwnerResponseDTO>> ownerCreation(@Valid @RequestBody PolicyOwnerRequestDTO policyOwnerRequestDTO) {
		
		PolicyOwnerResponseDTO createdOwner = policyOwnerService.createPolicyOwner(policyOwnerRequestDTO);
		
		ApiResponse<PolicyOwnerResponseDTO> apiResponse = new ApiResponse<PolicyOwnerResponseDTO>(
				LocalDateTime.now(),
				HttpStatus.CREATED.value(),
				"Policy Owner Created Successfully",
				createdOwner
				);
		
		return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
		}
	
	@GetMapping("/{userID}")
	public ResponseEntity<ApiResponse<PolicyOwnerResponseDTO>> findingUser(@PathVariable Long userID) {
		PolicyOwnerResponseDTO ownerResponseDTO = policyOwnerService.findUserByUserID(userID);
		
		ApiResponse<PolicyOwnerResponseDTO> userApiResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"User Successfully Retreived",
				ownerResponseDTO
				);
		return new ResponseEntity<>(userApiResponse,HttpStatus.OK);
	}
	
	@PostMapping("/agent/assign-agent")
	public ResponseEntity<ApiResponse<OwnerAgentMappingResponseDto>> mappingAgent(@Valid @RequestBody OwnerAgentMappingRequestDto mappingRequestDto) {
		OwnerAgentMappingResponseDto mappingResponseDto = policyOwnerService.mapAgentToOwner(mappingRequestDto);
		
		ApiResponse<OwnerAgentMappingResponseDto> userApiResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.CREATED.value(),
				"Agent Owner Mapping Created Successflly",
				mappingResponseDto
				);
		return new ResponseEntity<>(userApiResponse,HttpStatus.CREATED);
	}

}
