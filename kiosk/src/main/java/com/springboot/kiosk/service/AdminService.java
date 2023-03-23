package com.springboot.kiosk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kiosk.dto.AdminDTO;
import com.springboot.kiosk.mapper.IAdminMapper;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	IAdminMapper amapper;
	
	@Autowired
	AdminDTO aDto;
	
	//로그인
	@Override
	public int login(AdminDTO admin) {
		int result = amapper.login(admin);
		return result;
	}

}
