package com.alturion.policyowner.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;

@Mapper(componentModel = "spring")
public interface PolicyOwnerMapper {
	
	@Mapping(target = "createdAt",ignore = true)
	@Mapping(target = "updatedAt",ignore = true)
	@Mapping(target = "password",ignore = true)
	@Mapping(target = "roleType",ignore = true)
	public PolicyOwner toEntity(PolicyOwnerRequestDTO policyOwnerRequestDTO);
	public PolicyOwnerResponseDTO toResponseDto(PolicyOwner policyOwner); 
}
