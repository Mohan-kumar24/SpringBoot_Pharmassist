package com.springboot.pharmassist.requestdtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AdminRequest {
	
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Emain cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$",message = "invalid email")
	private String email;
    
    @NotNull(message = "phone number cannot be null")
    @NotBlank(message = "phone number cannot be blank")
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "invalid phone number")
	private String phoneNumber;
    
    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$"
    		+ "",message = "Password contain at least one upper case, lower case, special, number and password length 8-12")
	private String password;

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
