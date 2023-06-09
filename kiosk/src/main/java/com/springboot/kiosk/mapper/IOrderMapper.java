package com.springboot.kiosk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.kiosk.dto.OrderByTblNumDTO;
import com.springboot.kiosk.dto.OrderDTO;

@Mapper
public interface IOrderMapper {
	//주문하기
	public int order(OrderDTO order);
	
	//테이블넘버가져오기
	public List<Integer> getTableNums();
	
	//테이블넘버로 주문내역 가져오기
	public List<OrderByTblNumDTO> getOrderListBytableNum(int tableNum);
	
	//카카오페이로 주문 성공시 state 변경
	public int updateState(int tableNum);
	
	//결제완료 시, 음식 재고/판매량 수정
	public int updateInvenSales(int foodCode, int sales);
}
