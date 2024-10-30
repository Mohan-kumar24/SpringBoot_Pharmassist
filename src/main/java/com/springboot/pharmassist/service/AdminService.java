package com.springboot.pharmassist.service;

import org.springframework.stereotype.Service;

import com.springboot.pharmassist.entity.Admin;
import com.springboot.pharmassist.mapper.AdminMapper;
import com.springboot.pharmassist.repository.AdminRepository;
import com.springboot.pharmassist.requestdtos.AdminRequest;
import com.springboot.pharmassist.responsedtos.AdminResponse;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}

	public AdminResponse addAdmin(AdminRequest adminRequest) {

		Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
	}

}
