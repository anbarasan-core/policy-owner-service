package com.alturion.policyowner.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.alturion.policyowner.enums.UserRoleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="policy_owner_info")
public class PolicyOwner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userID;
	private String firstName;
	private String lastName;
	private String middleName;
	
	@Column(name="username",unique=true,nullable = false)
	private String username;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRoleType roleType;
	private LocalDate dateOfBirth;
	
	private String gender;
	
	@Column(name="aadhaar_number",unique=true,nullable = false)
	private String aadhaarNumber;
	@Column(name="pan_number",unique=true,nullable = false)
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
	
	private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    
	public PolicyOwner(Long userID, String firstName, String lastName, String middleName, String username, String password,UserRoleType roleType,LocalDate dateOfBirth,
			String gender, String aadhaarNumber, String panNumber, String contactNumber, String alternateContactNumber,
			String addressLine1, String addressLine2, String city, String state, String pinCode, String country,
			String beneficiaryName, String beneficiaryRelationship, String beneficiaryContactNumber,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.username = username;
		this.password = password;
		this.roleType = roleType;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.aadhaarNumber = aadhaarNumber;
		this.panNumber = panNumber;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryRelationship = beneficiaryRelationship;
		this.beneficiaryContactNumber = beneficiaryContactNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public PolicyOwner() {
		super();
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(UserRoleType roleType) {
		this.roleType = roleType;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
