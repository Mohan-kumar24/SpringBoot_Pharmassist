package com.springboot.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.springboot.pharmassist.entity.Admin;
import com.springboot.pharmassist.requestdtos.AdminRequest;
import com.springboot.pharmassist.responsedtos.AdminResponse;

@Component
public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest request,Admin admin) {
		admin.setEmail(request.getEmail());
		admin.setPhoneNumber(request.getPhoneNumber());
		admin.setPassword(request.getPassword());
		return admin;
	}
	
	public AdminResponse mapToAdminResponse(Admin admin)
	{
		AdminResponse resposne=new AdminResponse();
		resposne.setAdminId(admin.getAdminId());
		resposne.setEmail(admin.getEmail());
		resposne.setPhoneNumber(admin.getPhoneNumber());
		return resposne;
	}

}
