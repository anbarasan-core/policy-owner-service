package com.alturion.policyowner.service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alturion.policyowner.client.AgentClient;
import com.alturion.policyowner.domain.AgentOwnerMapping;
import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.dto.OwnerAgentMappingRequestDto;
import com.alturion.policyowner.dto.OwnerAgentMappingResponseDto;
import com.alturion.policyowner.dto.PolicyOwnerRequestDTO;
import com.alturion.policyowner.dto.PolicyOwnerResponseDTO;
import com.alturion.policyowner.exception.DuplicateMappingException;
import com.alturion.policyowner.exception.DuplicateUserException;
import com.alturion.policyowner.exception.ResourceNotFoundException;
import com.alturion.policyowner.mapper.PolicyOwnerMapper;
import com.alturion.policyowner.repository.AgentMappingRepository;
import com.alturion.policyowner.repository.PolicyOwnerRepository;

@Service
public class PolicyOwnerServiceImpl implements PolicyOwnerService{
	
	private static final Logger logger = Logger.getLogger(PolicyOwnerServiceImpl.class.getName());
	
	private final PolicyOwnerRepository policyOwnerRepository;
	private final PolicyOwnerMapper policyOwnerMapper;
	private final AgentClient agentClient;
	private final AgentMappingRepository mappingRepository;
	
	public PolicyOwnerServiceImpl(PolicyOwnerRepository policyOwnerRepository,
								  PolicyOwnerMapper policyOwnerMapper,
								  AgentClient agentClient,
								  AgentMappingRepository mappingRepository) {
		this.policyOwnerRepository = policyOwnerRepository;
		this.policyOwnerMapper = policyOwnerMapper;
		this.agentClient = agentClient;
		this.mappingRepository = mappingRepository;
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
													   .orElseThrow(()-> new ResourceNotFoundException("PolicyOwner Not Found for this ID"));
		PolicyOwnerResponseDTO policyOwnerResponseDTO = policyOwnerMapper.toResponseDto(policyOwner);
		return policyOwnerResponseDTO;
	}

	@Override
	public OwnerAgentMappingResponseDto mapAgentToOwner(OwnerAgentMappingRequestDto mappingRequestDto) {
		
		logger.info("Executing PolicyOwnerServiceImpl::mapAgentToOwner");
		
		//policyOwner validation
		policyOwnerRepository.findById(mappingRequestDto.getOwnerId())
				.orElseThrow(()-> new ResourceNotFoundException("PolicyOwner Not Found for this ID"));
		
		//agent validation
		agentClient.validateAgentExists(mappingRequestDto.getAgentId(), mappingRequestDto.getLicenseNumber());
		
		if(mappingRepository.existsByAgentIdAndOwnerId(
		        mappingRequestDto.getAgentId(),
		        mappingRequestDto.getOwnerId())) {

		    throw new DuplicateMappingException("Agent already mapped to this owner");
		}
		
		AgentOwnerMapping agentOwnerMapping = new AgentOwnerMapping();
		agentOwnerMapping.setAgentId(mappingRequestDto.getAgentId());
		agentOwnerMapping.setOwnerId(mappingRequestDto.getOwnerId());
		agentOwnerMapping.setAssignedDate(LocalDateTime.now());
		agentOwnerMapping.setUpdatedAt(LocalDateTime.now());
		agentOwnerMapping.setSourceType(mappingRequestDto.getSourceType());
		AgentOwnerMapping savedMapping = mappingRepository.save(agentOwnerMapping);
		OwnerAgentMappingResponseDto mappingResponseDto = new OwnerAgentMappingResponseDto();
		mappingResponseDto.setMappingCardNumber(savedMapping.getMappingCardNumber());
		mappingResponseDto.setAssignedDate(savedMapping.getAssignedDate());
		mappingResponseDto.setSourceType(savedMapping.getSourceType());
		return mappingResponseDto;			
	}

}
