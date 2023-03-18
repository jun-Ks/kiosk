package com.springboot.kiosk.service;

import java.util.List;

import com.springboot.kiosk.dto.OrderDTO;

public interface IOrderService {
	//주문하기
	public int order(OrderDTO order);
	
	//테이블넘버가져오기
	public List<Integer> getTableNums();
}
