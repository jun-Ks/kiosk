package com.springboot.kiosk.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class OrderByTblNumDTO {
	private int orderCode;
	private int foodCode;
	private int tableNum;
	private int totalCnt;
	private int totalPrice;
	private String type;
	private String name;
}
