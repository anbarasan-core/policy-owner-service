package com.alturion.policyowner.exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alturion.policyowner.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<ApiResponse<Void>> handleDuplicateUserException(DuplicateUserException duplicateException){
		ApiResponse<Void> duplicateUserResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				duplicateException.getMessage(),
				null
				);
		return new ResponseEntity<>(duplicateUserResponse,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiResponse<Void>> handleDataIntegrityViolationException (DataIntegrityViolationException dataIntegrityException){
		ApiResponse<Void> dataIntegrityResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				"Duplicate value violates database constraint",
				null
				);
		return new ResponseEntity<>(dataIntegrityResponse,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleGenericException (Exception exception){
		ApiResponse<Void> genericResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something Went Wrong",
				null
				);
		return new ResponseEntity<>(genericResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException (ResourceNotFoundException resourceException){
		ApiResponse<Void> resourceResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				resourceException.getMessage(),
				null
				);
		return new ResponseEntity<>(resourceResponse,HttpStatus.NOT_FOUND);
	}

}
