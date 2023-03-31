package com.springboot.kiosk.adminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/admin")
public class AdminGetController {
	
	@Autowired
	IFoodService fService;
	
	//관리자메인페이지
	@GetMapping("/")
	public ModelAndView adminPage() {
		ModelAndView adminPage = new ModelAndView("/admin/adminPage");
		
		return adminPage;
	}
	
	//제품등록페이지
	@GetMapping("/products")
	public ModelAndView productRegist() {
		ModelAndView productRegist = new ModelAndView("/admin/productRegist");
		
		return productRegist;
	}
	
	//제품조회페이지
	@GetMapping("/products/list")
	public ModelAndView productList() {
		ModelAndView productList = new ModelAndView("/admin/productList");
		
		return productList;
	}
	
	//제품list
	@GetMapping("/products/list/all")
	public List<FoodDTO> selectAll(){
		List<FoodDTO> foodListAll = fService.foodSelectAll();
		System.out.println(foodListAll);
		return foodListAll;
	}
}
