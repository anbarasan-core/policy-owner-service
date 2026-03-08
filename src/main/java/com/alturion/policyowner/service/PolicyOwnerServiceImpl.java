package com.alturion.policyowner.service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;
import com.alturion.policyowner.exception.DuplicateUserException;
import com.alturion.policyowner.exception.ResourceNotFoundException;
import com.alturion.policyowner.mapper.PolicyOwnerMapper;
import com.alturion.policyowner.repository.PolicyOwnerRepository;

@Service
public class PolicyOwnerServiceImpl implements PolicyOwnerService{
	
	private static final Logger logger = Logger.getLogger(PolicyOwnerServiceImpl.class.getName());
	
	private final PolicyOwnerRepository policyOwnerRepository;
	private final PolicyOwnerMapper policyOwnerMapper;
	
	public PolicyOwnerServiceImpl(PolicyOwnerRepository policyOwnerRepository,PolicyOwnerMapper policyOwnerMapper) {
		this.policyOwnerRepository = policyOwnerRepository;
		this.policyOwnerMapper = policyOwnerMapper;
	}

	@Override
	@Transactional
	public PolicyOwnerResponseDTO createPolicyOwner(PolicyOwnerRequestDTO policyOwnerRequestDTO){
		
		logger.info("Executing PolicyOwnerServiceImpl::createPolicyOwner");
		
		if(policyOwnerRepository.existsByAadhaarNumber(policyOwnerRequestDTO.getAadhaarNumber())){
			throw new DuplicateUserException("Same Aadhar Number - User already exists");
		}
		if(policyOwnerRepository.existsByPanNumber(policyOwnerRequestDTO.getPanNumber())) {
			throw new DuplicateUserException("Same Pan Number - User already exists");
		}
		
		PolicyOwner policyOwner = policyOwnerMapper.toEntity(policyOwnerRequestDTO);
		
		policyOwner.setCreatedAt(LocalDateTime.now());
		policyOwner.setUpdatedAt(LocalDateTime.now());

		PolicyOwner savedOwner = policyOwnerRepository.save(policyOwner);
		
		PolicyOwnerResponseDTO policyOwnerResponseDTO = policyOwnerMapper.toResponseDto(savedOwner);
		
		return policyOwnerResponseDTO;
		}

	@Override
	public PolicyOwnerResponseDTO findUserByUserID(Long userID) {
		
		logger.info("Executing PolicyOwnerServiceImpl::findUserByUserID");
		PolicyOwner policyOwner = policyOwnerRepository.findById(userID)
													   .orElseThrow(()-> new ResourceNotFoundException("User Not Found for this ID"));
		PolicyOwnerResponseDTO policyOwnerResponseDTO = policyOwnerMapper.toResponseDto(policyOwner);
		return policyOwnerResponseDTO;
	}

}
