package com.alturion.policyowner.service;

import java.util.List;

import com.alturion.policyowner.dto.OwnerAgentMappingRequestDto;
import com.alturion.policyowner.dto.OwnerAgentMappingResponseDto;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;
import com.alturion.policyowner.dto.PolicyOwnerSummaryDto;

public interface PolicyOwnerService {
	
	PolicyOwnerResponseDTO createPolicyOwner(PolicyOwnerRequestDTO policyOwnerDTO);
	
	PolicyOwnerResponseDTO findUserByUserID(Long userID);
	
	OwnerAgentMappingResponseDto mapAgentToOwner(OwnerAgentMappingRequestDto mappingRequestDto);
	
	List<PolicyOwnerSummaryDto> findOwnersByAgent(Long agentId);

}
