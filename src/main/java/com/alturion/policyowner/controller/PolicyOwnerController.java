package com.alturion.policyowner.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alturion.policyowner.common.ApiResponse;
import com.alturion.policyowner.dto.AuthRequestDto;
import com.alturion.policyowner.dto.AuthResponseDto;
import com.alturion.policyowner.dto.OwnerAgentMappingRequestDto;
import com.alturion.policyowner.dto.OwnerAgentMappingResponseDto;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;
import com.alturion.policyowner.dto.PolicyOwnerSummaryDto;
import com.alturion.policyowner.service.AuthService;
import com.alturion.policyowner.service.PolicyOwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policyowners")
public class PolicyOwnerController {
	
	private final PolicyOwnerService policyOwnerService;
	private final AuthService authService;
	
	public PolicyOwnerController(PolicyOwnerService policyOwnerService,AuthService authService) {
		this.policyOwnerService = policyOwnerService;
		this.authService = authService;
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
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AuthResponseDto>> loginOwner(@RequestBody AuthRequestDto authRequestDto) {
			
		String token = authService.login(authRequestDto.getUsername(), authRequestDto.getPassword());
		ApiResponse<AuthResponseDto> apiResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"Login Successfull",
				new AuthResponseDto(token)
				);
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}
	
	@GetMapping("/{userID}")
	@PreAuthorize("isAuthenticated() and hasRole('OWNER') and #userID==principal.userID")
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
	
	@GetMapping("/agent/{agentId}")
	public ResponseEntity<ApiResponse<List<PolicyOwnerSummaryDto>>> fetchOwnersUnderAgent(@PathVariable Long agentId) {
		
		List<PolicyOwnerSummaryDto> fetchAllOwners = policyOwnerService.findOwnersByAgent(agentId);
		ApiResponse<List<PolicyOwnerSummaryDto>> userApiResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.OK.value(),
				"Owners under this agent fetched Successflly",
				fetchAllOwners
				);
		return new ResponseEntity<>(userApiResponse,HttpStatus.OK);
	}

}
