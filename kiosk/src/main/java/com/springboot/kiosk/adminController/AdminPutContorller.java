package com.springboot.kiosk.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/admin")
public class AdminPutContorller {
	
	@Autowired
	IFoodService fService;
	
	//제품수정
	@PutMapping("/products/list/u/{code}")
	public int productUpdate(@PathVariable int code, @RequestBody FoodDTO food) {
		int result = fService.updateProduct(code, food);
		
		return result;
	}
}
