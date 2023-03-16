package com.springboot.kiosk.userContorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kiosk.dto.OrderDTO;
import com.springboot.kiosk.service.IOrderService;

@RestController
@RequestMapping("/user")
public class UserPostController {
	
	@Autowired
	IOrderService oService;
	
	@Autowired
	OrderDTO order;
	
	@PostMapping("/order")
	public void order(OrderDTO orderDto) {
		System.out.println(orderDto.toString());
	}
}
