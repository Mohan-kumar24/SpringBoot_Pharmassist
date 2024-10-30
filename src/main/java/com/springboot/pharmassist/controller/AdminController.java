package com.springboot.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pharmassist.requestdtos.AdminRequest;
import com.springboot.pharmassist.responsedtos.AdminResponse;
import com.springboot.pharmassist.service.AdminService;
import com.springboot.pharmassist.utility.AppResponseBuilder;
import com.springboot.pharmassist.utility.ResponseStructure;

import jakarta.validation.Valid;
@RestController
public class AdminController {
	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;
	
    public AdminController(AdminService adminService, AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}

	@PostMapping("/admin/save")
	public ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@Valid @RequestBody AdminRequest adminRequest)
	{
		AdminResponse response=adminService.addAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED, "Admin Created", response);
	}

}
