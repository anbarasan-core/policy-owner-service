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
import com.alturion.policyowner.repository.PolicyOwnerRepository;

@Service
public class PolicyOwnerServiceImpl implements PolicyOwnerService{
	
	private static final Logger logger = Logger.getLogger(PolicyOwnerServiceImpl.class.getName());
	
	private final PolicyOwnerRepository policyOwnerRepository;
	
	public PolicyOwnerServiceImpl(PolicyOwnerRepository policyOwnerRepository) {
		this.policyOwnerRepository = policyOwnerRepository;
	}

	@Override
	@Transactional
	public PolicyOwnerResponseDTO createPolicyOwner(PolicyOwnerRequestDTO policyOwnerRequestDTO){
		
		logger.info("Executing PolicyOwnerServiceImpl::createPolicyOwner");
		PolicyOwner policyOwner = new PolicyOwner();
		PolicyOwnerResponseDTO policyOwnerResponseDTO = new PolicyOwnerResponseDTO();
		policyOwner.setFirstName(policyOwnerRequestDTO.getFirstName());
		policyOwner.setLastName(policyOwnerRequestDTO.getLastName());
		policyOwner.setMiddleName(policyOwnerRequestDTO.getMiddleName());
		policyOwner.setDateOfBirth(policyOwnerRequestDTO.getDateOfBirth());
		policyOwner.setGender(policyOwnerRequestDTO.getGender());
		policyOwner.setAadhaarNumber(policyOwnerRequestDTO.getAadhaarNumber());
		policyOwner.setPanNumber(policyOwnerRequestDTO.getPanNumber());
		policyOwner.setContactNumber(policyOwnerRequestDTO.getContactNumber());
		policyOwner.setAlternateContactNumber(policyOwnerRequestDTO.getAlternateContactNumber());
		policyOwner.setAddressLine1(policyOwnerRequestDTO.getAddressLine1());
		policyOwner.setAddressLine2(policyOwnerRequestDTO.getAddressLine2());
		policyOwner.setCity(policyOwnerRequestDTO.getCity());
		policyOwner.setState(policyOwnerRequestDTO.getState());
		policyOwner.setPinCode(policyOwnerRequestDTO.getPinCode());
		policyOwner.setCountry(policyOwnerRequestDTO.getCountry());
		policyOwner.setBeneficiaryName(policyOwnerRequestDTO.getBeneficiaryName());
		policyOwner.setBeneficiaryRelationship(policyOwnerRequestDTO.getBeneficiaryRelationship());
		policyOwner.setBeneficiaryContactNumber(policyOwnerRequestDTO.getBeneficiaryContactNumber());
		policyOwner.setAgentId(policyOwnerRequestDTO.getAgentId());
		policyOwner.setCreatedAt(LocalDateTime.now());
		policyOwner.setUpdatedAt(LocalDateTime.now());
		
		if(policyOwnerRepository.existsByAadhaarNumber(policyOwnerRequestDTO.getAadhaarNumber())){
			throw new DuplicateUserException("Same Aadhar Number - User already exists");
		}
		if(policyOwnerRepository.existsByPanNumber(policyOwnerRequestDTO.getPanNumber())) {
			throw new DuplicateUserException("Same Pan Number - User already exists");
		}

		PolicyOwner savedOwner = policyOwnerRepository.save(policyOwner);
		
		policyOwnerResponseDTO.setUserID(savedOwner.getUserID());
		policyOwnerResponseDTO.setFirstName(savedOwner.getFirstName());
		policyOwnerResponseDTO.setLastName(savedOwner.getLastName());
		policyOwnerResponseDTO.setMiddleName(savedOwner.getMiddleName());
		policyOwnerResponseDTO.setDateOfBirth(savedOwner.getDateOfBirth());
		policyOwnerResponseDTO.setGender(savedOwner.getGender());
		policyOwnerResponseDTO.setAadhaarNumber(savedOwner.getAadhaarNumber());
		policyOwnerResponseDTO.setPanNumber(savedOwner.getPanNumber());
		policyOwnerResponseDTO.setContactNumber(savedOwner.getContactNumber());
		policyOwnerResponseDTO.setAlternateContactNumber(savedOwner.getAlternateContactNumber());
		policyOwnerResponseDTO.setAddressLine1(savedOwner.getAddressLine1());
		policyOwnerResponseDTO.setAddressLine2(savedOwner.getAddressLine2());
		policyOwnerResponseDTO.setCity(savedOwner.getCity());
		policyOwnerResponseDTO.setState(savedOwner.getState());
		policyOwnerResponseDTO.setPinCode(savedOwner.getPinCode());
		policyOwnerResponseDTO.setCountry(savedOwner.getCountry());
		policyOwnerResponseDTO.setBeneficiaryName(savedOwner.getBeneficiaryName());
		policyOwnerResponseDTO.setBeneficiaryRelationship(savedOwner.getBeneficiaryRelationship());
		policyOwnerResponseDTO.setBeneficiaryContactNumber(savedOwner.getBeneficiaryContactNumber());
		policyOwnerResponseDTO.setAgentId(savedOwner.getAgentId());
		policyOwnerResponseDTO.setCreatedAt(savedOwner.getCreatedAt());
		policyOwnerResponseDTO.setUpdatedAt(savedOwner.getUpdatedAt());
		
		return policyOwnerResponseDTO;
		}

	@Override
	public PolicyOwnerResponseDTO findUserByUserID(Long userID) {
		PolicyOwner policyOwner = policyOwnerRepository.findById(userID)
													   .orElseThrow(()-> new ResourceNotFoundException("User Not Found for this ID"));
		PolicyOwnerResponseDTO policyOwnerResponseDTO = new PolicyOwnerResponseDTO();
		policyOwnerResponseDTO.setUserID(policyOwner.getUserID());
		policyOwnerResponseDTO.setFirstName(policyOwner.getFirstName());
		policyOwnerResponseDTO.setLastName(policyOwner.getLastName());
		policyOwnerResponseDTO.setMiddleName(policyOwner.getMiddleName());
		policyOwnerResponseDTO.setDateOfBirth(policyOwner.getDateOfBirth());
		policyOwnerResponseDTO.setGender(policyOwner.getGender());
		policyOwnerResponseDTO.setAadhaarNumber(policyOwner.getAadhaarNumber());
		policyOwnerResponseDTO.setPanNumber(policyOwner.getPanNumber());
		policyOwnerResponseDTO.setContactNumber(policyOwner.getContactNumber());
		policyOwnerResponseDTO.setAlternateContactNumber(policyOwner.getAlternateContactNumber());
		policyOwnerResponseDTO.setAddressLine1(policyOwner.getAddressLine1());
		policyOwnerResponseDTO.setAddressLine2(policyOwner.getAddressLine2());
		policyOwnerResponseDTO.setCity(policyOwner.getCity());
		policyOwnerResponseDTO.setState(policyOwner.getState());
		policyOwnerResponseDTO.setPinCode(policyOwner.getPinCode());
		policyOwnerResponseDTO.setCountry(policyOwner.getCountry());
		policyOwnerResponseDTO.setBeneficiaryName(policyOwner.getBeneficiaryName());
		policyOwnerResponseDTO.setBeneficiaryRelationship(policyOwner.getBeneficiaryRelationship());
		policyOwnerResponseDTO.setBeneficiaryContactNumber(policyOwner.getBeneficiaryContactNumber());
		policyOwnerResponseDTO.setAgentId(policyOwner.getAgentId());
		policyOwnerResponseDTO.setCreatedAt(policyOwner.getCreatedAt());
		policyOwnerResponseDTO.setUpdatedAt(policyOwner.getUpdatedAt());
		return policyOwnerResponseDTO;
	}

}
