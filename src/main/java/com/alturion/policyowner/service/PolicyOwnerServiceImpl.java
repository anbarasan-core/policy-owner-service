package com.alturion.policyowner.service;

import org.springframework.stereotype.Service;

import com.alturion.policyowner.dto.PolicyOwnerDTO;

@Service
public class PolicyOwnerServiceImpl implements PolicyOwnerService{

	@Override
	public PolicyOwnerDTO createPolicyOwner(PolicyOwnerDTO policyOwnerDTO) {
		return policyOwnerDTO;
	}

}
