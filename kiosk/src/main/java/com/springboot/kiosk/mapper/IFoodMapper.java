package com.springboot.kiosk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.kiosk.dto.FoodDTO;

@Mapper
public interface IFoodMapper {
	//음식등록하기
	public int insertFood(FoodDTO food);
	
	//카테고리조회
	public List<FoodDTO> foodListByCategory(String category);
	
	//음식코드로 조회
	public FoodDTO foodListByCode(int foodCode);
	
	//음식 모두 조회
	public List<FoodDTO> foodSelectAll();
	
	//코드로 음식삭제
	public int deleteProduct(int code);
	
	//음식정보수정
	public int updateProduct(int code, @Param("food") FoodDTO food);
}
