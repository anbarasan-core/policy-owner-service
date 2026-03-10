package com.alturion.policyowner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alturion.policyowner.domain.AgentOwnerMapping;

public interface AgentMappingRepository extends JpaRepository<AgentOwnerMapping,Long>{
	
	boolean existsByAgentIdAndOwnerId(Long ownerId,Long agentId);
	
	List<AgentOwnerMapping> findAllByAgentIdAndRemovedDateIsNull(Long agentId);

}
