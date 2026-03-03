package com.alturion.policyowner.service;

import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;

public interface PolicyOwnerService {
	
	PolicyOwnerResponseDTO createPolicyOwner(PolicyOwnerRequestDTO policyOwnerDTO);
	
	PolicyOwnerResponseDTO findUserByUserID(Long userID);

}
