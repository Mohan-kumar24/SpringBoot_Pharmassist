package com.springboot.pharmassist.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.pharmassist.utility.ErrorStructure;

@RestControllerAdvice
public class FieldErrorExceptionalHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<ObjectError> errors=ex.getAllErrors();

		List<FieldErrorStructure> errorRsponse =new ArrayList<>();

		for(ObjectError error:errors)
		{
			FieldError fr=(FieldError)error;
			String message=fr.getDefaultMessage();
			String field=fr.getField();
			Object rejectedValue=fr.getRejectedValue();

			errorRsponse.add(new FieldErrorStructure(message, field, rejectedValue));
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorStructure.create(HttpStatus.BAD_REQUEST, "Invalid Input", errorRsponse));
	}

	private class FieldErrorStructure {

		private String message;
		private String field;
		private Object rejectedValue;
		
		public FieldErrorStructure(String message, String field, Object rejectedValue) {
			super();
			this.message = message;
			this.field = field;
			this.rejectedValue = rejectedValue;
		}
		
		public String getMessage() {
			return message;
		}
		
		public String getField() {
			return field;
		}
		
		public Object getRejectedValue() {
			return rejectedValue;
		}
	}

}
