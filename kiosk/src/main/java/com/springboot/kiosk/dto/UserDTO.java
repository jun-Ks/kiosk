package com.springboot.kiosk.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserDTO {
	private int userNum;
	private String id;
	private String pw;
	private String name;
}
