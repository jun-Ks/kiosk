package com.springboot.kiosk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.kiosk.dto.OrderByTblNumDTO;
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

	@Override
	public List<Integer> getTableNums() {
		List<Integer> tableNums = omapper.getTableNums();
		return tableNums;
	}

	@Override
	public List<OrderByTblNumDTO> getOrderListBytableNum(int tableNum) {
		List<OrderByTblNumDTO> getOrderListBytableNum = omapper.getOrderListBytableNum(tableNum);
		return getOrderListBytableNum;
	}

}
