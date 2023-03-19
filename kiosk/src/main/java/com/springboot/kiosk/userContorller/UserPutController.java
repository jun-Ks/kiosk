package com.springboot.kiosk.userContorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.service.OrderService;

@RestController
@RequestMapping("/user")
public class UserPutController {
	
	@Autowired
	OrderService oService;
	
	@PutMapping("/state/{tableNum}")
	public int updateState(@PathVariable int tableNum) {
		
		int result = oService.updateState(tableNum);
		
		
		return result;
	}
}
