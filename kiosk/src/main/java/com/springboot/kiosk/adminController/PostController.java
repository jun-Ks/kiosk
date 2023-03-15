package com.springboot.kiosk.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/admin")
public class PostController {
	
	@Autowired
	IFoodService fService;
	
	@Autowired
	FoodDTO food;
	
	@PostMapping("/food")
	public int insertFood(FoodDTO food) {
		int result = fService.insertFood(food);
		
		return result;
	}
}
