package com.springboot.kiosk.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kiosk.dto.OrderDTO;

@Mapper
public interface IOrderMapper {
	//주문하기
	public int order(OrderDTO order);
}
