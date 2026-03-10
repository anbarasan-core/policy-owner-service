package com.alturion.policyowner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alturion.policyowner.domain.AgentOwnerMapping;

public interface AgentMappingRepository extends JpaRepository<AgentOwnerMapping,Long>{
	
	boolean existsByAgentIdAndOwnerId(Long ownerId,Long agentId);

}
