package com.springboot.kiosk.service;

import com.springboot.kiosk.dto.OrderDTO;

public interface IOrderService {
	//주문하기
	public int order(OrderDTO order);
}
