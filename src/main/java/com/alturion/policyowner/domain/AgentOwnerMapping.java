package com.alturion.policyowner.domain;

import java.time.LocalDateTime;

import com.alturion.policyowner.enums.SourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "agent_owner_mapping")
public class AgentOwnerMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mappingId;
	@NotNull
	private Long ownerId;
	private Long agentId;
	private String mappingCardNumber;
	private LocalDateTime assignedDate;
	private LocalDateTime updatedAt;
	private LocalDateTime removedDate;
	@NotNull
	@Enumerated(EnumType.STRING)
	private SourceType sourceType;
	
	public AgentOwnerMapping() {
		super();
	}
	
	public AgentOwnerMapping(Long mappingId, Long ownerId, Long agentId, String mappingCardNumber,
			LocalDateTime assignedDate, LocalDateTime updatedAt, LocalDateTime removedDate, SourceType sourceType) {
		super();
		this.mappingId = mappingId;
		this.ownerId = ownerId;
		this.agentId = agentId;
		this.mappingCardNumber = mappingCardNumber;
		this.assignedDate = assignedDate;
		this.updatedAt = updatedAt;
		this.removedDate = removedDate;
		this.sourceType = sourceType;
	}
	
	@PostPersist
	public void initMappingCardNumber() {
		this.mappingCardNumber = String.format("AG-PO-RL-%04d", this.mappingId);
	}
	
	public Long getMappingId() {
		return mappingId;
	}
	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getAgentId() {
		return agentId;
	}
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}
	public String getMappingCardNumber() {
		return mappingCardNumber;
	}
	public void setMappingCardNumber(String mappingCardNumber) {
		this.mappingCardNumber = mappingCardNumber;
	}
	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDateTime getRemovedDate() {
		return removedDate;
	}
	public void setRemovedDate(LocalDateTime removedDate) {
		this.removedDate = removedDate;
	}
	public SourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}
	
	
}
