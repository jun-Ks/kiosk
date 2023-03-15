package com.springboot.kiosk.service;

import java.util.List;

import com.springboot.kiosk.dto.FoodDTO;

public interface IFoodService {
	//음식 등록
	public int insertFood(FoodDTO food);
	
	//카테고리로 음식조회
	public List<FoodDTO> foodListByCategory(String category);
	
	//코드로 음식조회
	public FoodDTO foodListByCode(int foodCode);
}
