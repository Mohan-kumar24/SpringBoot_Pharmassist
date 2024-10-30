package com.springboot.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pharmassist.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>  {

}
