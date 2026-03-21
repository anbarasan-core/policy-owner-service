package com.alturion.policyowner.security.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alturion.policyowner.domain.PolicyOwner;
import com.alturion.policyowner.repository.PolicyOwnerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	private final PolicyOwnerRepository policyOwnerRepository;
	
	public CustomUserDetailsService(PolicyOwnerRepository policyOwnerRepository) {
		this.policyOwnerRepository = policyOwnerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("Executing CustomUserDetailsService::loadUserByUsername");
		PolicyOwner policyOwner = policyOwnerRepository.findByUsername(username)
													  .orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
		
		return new CustomUserDetails(policyOwner);
	}

}
