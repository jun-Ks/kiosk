package com.springboot.kiosk.userContorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.dto.OrderByTblNumDTO;
import com.springboot.kiosk.dto.OrderDTO;
import com.springboot.kiosk.service.IFoodService;
import com.springboot.kiosk.service.IOrderService;

@RestController
@RequestMapping("/user")
public class UserGetController {
	
	@Autowired
	IFoodService fService;
	
	@Autowired
	IOrderService oService;
	
	@Autowired
	FoodDTO fDto;
	
	@Autowired
	OrderDTO oDto;
	
	@GetMapping("/menu/{food-orders}")
	public ModelAndView menu(@PathVariable ("food-orders") String selected, Model model) {
		if(selected.equals("forhere")) {
			model.addAttribute("forhere", "forehere");
			
			ModelAndView menu = new ModelAndView("/user/menu");
			return menu;
			
		}else {
			model.addAttribute("togo", "togo");
			
			ModelAndView menu = new ModelAndView("/user/menu");
			return menu;
		}
	}
	
	@GetMapping("/foodlist")
	public List<FoodDTO> foodList(String category) {
		
		List<FoodDTO> foodList = fService.foodListByCategory(category);
		
		return foodList;
	}
	
	@GetMapping("/cart/{foodCode}")
	public FoodDTO cartList(@PathVariable("foodCode") int foodCode){
		
		FoodDTO food = fService.foodListByCode(foodCode);
		
		return food;
	}
	
	//테이블 넘버가져와서 비교 후 리턴
	@GetMapping("/table-nums")
	public int makeTableNums() {
		List<Integer> getTableNums = oService.getTableNums();
		int tableNums = 0;
		//0, 1
		while(true)	{
			if(tableNums == getTableNums.get(tableNums)){
				tableNums++;
			}else {
				break;
			}
		}
		
		return tableNums;
	}
	
	//주문결제페이지
	@GetMapping("/orderType")
	public ModelAndView orderType() {
		ModelAndView orderType = new ModelAndView("/user/orderType");
		return orderType;
	}
	
	//테이블번호로 주문내역 불러오기
	@GetMapping("/orderlist/{tableNum}")
	public List<OrderByTblNumDTO> getOrderListBytableNum(@PathVariable("tableNum") int tableNum){
		List<OrderByTblNumDTO> orderLists = oService.getOrderListBytableNum(tableNum);
		return orderLists;
	}
	
	
}
