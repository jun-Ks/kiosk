package com.springboot.kiosk.userContorller;

import java.util.List;

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

	
	@PostMapping("/menu/order")
	public void order(
			int[] foodCode, 
			int[] totalCnt, 
			int[] totalPrice,
			String type,
			int tableNum
			) {
		for(int i = 0; i < foodCode.length; i++) {
			OrderDTO order = new OrderDTO();
			order.setFoodCode(foodCode[i]);
			order.setTotalCnt(totalCnt[i]);
			order.setTotalPrice(totalPrice[i]);
			order.setType(type);
			order.setTableNum(tableNum);
			
			oService.order(order);
			
		}
	}
}
