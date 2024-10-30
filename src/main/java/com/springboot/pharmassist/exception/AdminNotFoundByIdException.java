package com.springboot.pharmassist.exception;

public class AdminNotFoundByIdException extends RuntimeException {
	
	private String message;

  public AdminNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

@Override
	public String getMessage() {
		return message;
	}


}
