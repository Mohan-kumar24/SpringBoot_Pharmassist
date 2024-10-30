package com.springboot.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.pharmassist.entity.Admin;
import com.springboot.pharmassist.exception.AdminNotFoundByIdException;
import com.springboot.pharmassist.utility.AppResponseBuilder;
import com.springboot.pharmassist.utility.ErrorStructure;

@RestControllerAdvice
public class AdminExceptionHandler {
	
	private final AppResponseBuilder responseBuilder;

	public AdminExceptionHandler(AppResponseBuilder responseBuilder) {
		super();
		this.responseBuilder = responseBuilder;
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> handleAdminNotFoundById(AdminNotFoundByIdException exc)
	{
		return responseBuilder.error(HttpStatus.NOT_FOUND, exc.getMessage(),
				"The user By the given Id is Not Found In The DataBase");
	}

}
