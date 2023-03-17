package com.springboot.kiosk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kiosk.dto.OrderDTO;
import com.springboot.kiosk.mapper.IOrderMapper;

@Service
public class OrderService implements IOrderService{
	@Autowired
	IOrderMapper omapper;
	
	@Autowired
	OrderDTO oDto;
	
	@Override
	public int order(OrderDTO order) {
		int result = omapper.order(order);
		return result;
	}

}
