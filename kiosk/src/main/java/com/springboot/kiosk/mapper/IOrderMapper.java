package com.springboot.kiosk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kiosk.dto.OrderDTO;

@Mapper
public interface IOrderMapper {
	//주문하기
	public int order(OrderDTO order);
	
	//테이블넘버가져오기
	public List<Integer> getTableNums();
}
