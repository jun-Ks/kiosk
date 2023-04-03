package com.springboot.kiosk.userContorller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kiosk.dto.OrderDTO;
import com.springboot.kiosk.service.IOrderService;

@RestController
@RequestMapping("/user")
public class UserPostController {
	
	@Autowired
	IOrderService oService;

	//주문하기
	@PostMapping("/menu/order")
	public ModelAndView order(
			int[] foodCode, 
			int[] totalCnt, 
			int[] totalPrice,
			String type,
			int tableNum
			) {
		OrderDTO order = null;
		ArrayList<OrderDTO> orders = new ArrayList<>();
		int result = 0;
		ModelAndView orderType = new ModelAndView("/user/orderType");
		for(int i = 0; i < foodCode.length; i++) {
			
			order = new OrderDTO();
			
			order.setFoodCode(foodCode[i]);
			order.setTotalCnt(totalCnt[i]);
			order.setTotalPrice(totalPrice[i]);
			order.setType(type);
			order.setTableNum(tableNum);
			
			result = oService.order(order);
			
			orders.add(order);
		}
		orderType.addObject("result", result);
		orderType.addObject("tableNum", tableNum);
		orderType.addObject("orders", orders);
		
		return orderType;
	}
}
