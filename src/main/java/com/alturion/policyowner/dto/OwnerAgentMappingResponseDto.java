package com.alturion.policyowner.dto;

import java.time.LocalDateTime;

import com.alturion.policyowner.enums.SourceType;

public class OwnerAgentMappingResponseDto {

	private String mappingCardNumber;
	private LocalDateTime assignedDate;
	private SourceType sourceType;
	
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
	public SourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}
}
