package com.springboot.kiosk.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/admin")
public class AdminDeleteController {
	
	@Autowired
	IFoodService fService;
	
	//코드로 제품삭제
	@DeleteMapping("/products/list/d/{code}")
	public int deleteProduct(@PathVariable int code) {
		int result = fService.deleteProduct(code);
		
		return result;
	}
}
