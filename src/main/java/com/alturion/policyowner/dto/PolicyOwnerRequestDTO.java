package com.alturion.policyowner.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PolicyOwnerRequestDTO {
	
	private String firstName;
	private String lastName;
	private String middleName;
	
	private LocalDate dateOfBirth;
	
	private String gender;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]{12}$", message = "Invalid Aadhar number")
	private String aadhaarNumber;
	@NotBlank
	@Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "Invalid PAN number")
	private String panNumber;
	private String contactNumber;
	private String alternateContactNumber;
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pinCode;
	private String country;
	
	private String beneficiaryName;
	private String beneficiaryRelationship;
	private String beneficiaryContactNumber;
	private Long agentId;
	
	
	public PolicyOwnerRequestDTO() {
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}
	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryRelationship() {
		return beneficiaryRelationship;
	}
	public void setBeneficiaryRelationship(String beneficiaryRelationship) {
		this.beneficiaryRelationship = beneficiaryRelationship;
	}
	public String getBeneficiaryContactNumber() {
		return beneficiaryContactNumber;
	}
	public void setBeneficiaryContactNumber(String beneficiaryContactNumber) {
		this.beneficiaryContactNumber = beneficiaryContactNumber;
	}
	public Long getAgentId() {
		return agentId;
	}
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}
	
	

}
