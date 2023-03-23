package com.springboot.kiosk.service;

import com.springboot.kiosk.dto.AdminDTO;

public interface IAdminService {
	//로그인
	public int login(AdminDTO admin);
}
