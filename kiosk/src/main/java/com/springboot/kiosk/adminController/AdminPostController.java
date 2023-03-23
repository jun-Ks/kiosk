package com.springboot.kiosk.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.dto.AdminDTO;
import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IAdminService;
import com.springboot.kiosk.service.IFoodService;


@RestController
@RequestMapping("/admin")

public class AdminPostController {
	
	@Autowired
	IFoodService fService;
	
	@Autowired
	IAdminService aService;
	
	@Autowired
	FoodDTO food;
	
	@PostMapping("/food")
	public int insertFood(FoodDTO food) {
		int result = fService.insertFood(food);
		
		return result;
	}
	
	@PostMapping("/login")
	public int login(@RequestBody AdminDTO admin) {
		int result = aService.login(admin);
		
		return result;
	}
}
