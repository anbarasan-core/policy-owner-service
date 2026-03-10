package com.alturion.policyowner.client;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.alturion.policyowner.exception.DependencyServiceUnavailableException;
import com.alturion.policyowner.exception.ResourceNotFoundException;

@Component
public class AgentClient {
	
	Logger logger = Logger.getLogger(AgentClient.class.getName());
	
	private RestTemplate restTemplate;
	private String agentServiceUrl;
	
	public AgentClient(RestTemplate restTemplate, @Value("${alturion.agent.service.url}") String agentServiceUrl) {
		
		this.restTemplate = restTemplate;
		this.agentServiceUrl = agentServiceUrl;
	}
	
	public void validateAgentExists(Long agentId,String licenseNumber) {
		
		logger.info("Executing AgentClient::validateAgentExists");
		String url = agentServiceUrl+agentId+"/"+licenseNumber;
		logger.info("GET "+url);
		try {
			restTemplate.getForObject(url, Object.class);
		}
		catch(HttpClientErrorException httpException) {
			if(httpException.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new ResourceNotFoundException("Agent Details Not Found");
			}
		}
		catch(ResourceAccessException resourceException) {
			throw new DependencyServiceUnavailableException("Dependency Service is Not Available");
		}

	}

}
