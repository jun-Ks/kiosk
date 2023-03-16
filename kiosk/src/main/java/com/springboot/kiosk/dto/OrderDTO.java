package com.springboot.kiosk.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class OrderDTO {
	private int orderCode;
	private int foodCode;
	private int totalCnt;
	private int totalPrice;
	private Timestamp orderTime;
}
