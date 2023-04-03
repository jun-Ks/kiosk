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
	
	//결제완료시 state 변경	
	@PutMapping("/state/{tableNum}")
	public int updateState(@PathVariable int tableNum) {
		
		int result = oService.updateState(tableNum);
		
		
		return result;
	}
	
	//결제완료 시 재고, 판매량 수정
	@PutMapping("/inven-sales/{foodCode}/{count}")
	public int updateInvenSales(@PathVariable int foodCode, @PathVariable int count) {
		
		int result = oService.updateInvenSales(foodCode, count);
		return result;
	}
}
