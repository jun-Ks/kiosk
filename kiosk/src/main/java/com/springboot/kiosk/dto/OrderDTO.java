package com.springboot.kiosk.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor	
@AllArgsConstructor
public class OrderDTO {
	private int orderCode;
	private int foodCode;
	private int tableNum;
	private int totalCnt;
	private int totalPrice;
	private String type;
	private int state;
	private Timestamp orderTime;
}
