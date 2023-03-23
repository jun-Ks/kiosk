package com.springboot.kiosk.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kiosk.dto.AdminDTO;

@Mapper
public interface IAdminMapper {
	//로그인
	public int login(AdminDTO admin);
}
