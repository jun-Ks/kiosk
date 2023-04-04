package com.springboot.kiosk.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FoodDTO {
	private int foodCode;
	private String name;
	private int price;
	private String category;
	private int inventory;
	private String img;
	private int sales;
}
