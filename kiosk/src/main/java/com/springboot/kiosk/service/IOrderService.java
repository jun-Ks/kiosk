package com.springboot.kiosk.service;

import java.util.List;

import com.springboot.kiosk.dto.OrderByTblNumDTO;
import com.springboot.kiosk.dto.OrderDTO;

public interface IOrderService {
	//주문하기
	public int order(OrderDTO order);
	
	//테이블넘버가져오기
	public List<Integer> getTableNums();
	
	//테이블 넘버로 주문내역 가져오기
	public List<OrderByTblNumDTO> getOrderListBytableNum(int tableNum);
	
	//카카오페이로 주문 성공 시 state변경
	public int updateState(int tableNum);
	
	//결제완료 시, 음식 재고/판매량 수정
	public int updateInvenSales(int foodCode, int sales);
}
