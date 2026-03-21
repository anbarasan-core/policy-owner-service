package com.alturion.policyowner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alturion.policyowner.domain.PolicyOwner;

public interface PolicyOwnerRepository extends JpaRepository<PolicyOwner,Long> {
	
	boolean existsByAadhaarNumber(String aadharNumber);
	boolean existsByPanNumber(String panNumber);
	
	List<PolicyOwner> findByUserIDIn(List<Long> ownerIds);
	Optional<PolicyOwner> findByUsername(String username);

}
