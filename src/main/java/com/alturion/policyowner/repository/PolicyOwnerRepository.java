package com.alturion.policyowner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;

public interface PolicyOwnerRepository extends JpaRepository<PolicyOwner,Long> {
	
	boolean existsByAadhaarNumber(String aadharNumber);
	boolean existsByPanNumber(String panNumber);

}
