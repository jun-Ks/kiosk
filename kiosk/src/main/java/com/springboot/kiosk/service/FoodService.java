package com.springboot.kiosk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.mapper.IFoodMapper;

@Service
public class FoodService implements IFoodService{
	
	@Autowired
	IFoodMapper fmapper;
	
	@Autowired
	FoodDTO fDto;
	
	//음식등록
	@Override
	public int insertFood(FoodDTO food) {
		int result = fmapper.insertFood(food);
		return result;
	}
	
	//카테고리 음식조회
	@Override
	public List<FoodDTO> foodListByCategory(String category) {
		List<FoodDTO> foodList = fmapper.foodListByCategory(category);
		
		return foodList;
	}
	
	//코드로 음식조회
	@Override
	public FoodDTO foodListByCode(int foodCode) {
		FoodDTO food = fmapper.foodListByCode(foodCode);
		return food;
	}

	//모든 음식 조회
	@Override
	public List<FoodDTO> foodSelectAll() {
		List<FoodDTO> foodListAll = fmapper.foodSelectAll();
		return foodListAll;
	}

	//코드로 음식삭제
	@Override
	public int deleteProduct(int code) {
		int result = fmapper.deleteProduct(code);
		return result;
	}

	@Override
	public int updateProduct(int code, FoodDTO food) {
		System.out.println(food.toString());
		int result = fmapper.updateProduct(code, food);
		return result;
	}
	
	
}
