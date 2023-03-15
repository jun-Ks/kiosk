package com.springboot.kiosk.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FoodDTO {
	int foodCode;
	String name;
	int price;
	String category;
	String inventory;
	String img;
}
