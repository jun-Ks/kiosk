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
import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/user")
public class GetController {
	
	@Autowired
	IFoodService fService;
	
	@Autowired
	FoodDTO fDto;
	
	@GetMapping("/menu/{food-orders}")
	public ModelAndView menu(@PathVariable ("food-orders") String selected, Model model) {
		if(selected.equals("forhere")) {
			model.addAttribute("forhere", "forehere");
			
			ModelAndView menu = new ModelAndView("menu");
			return menu;
			
		}else {
			model.addAttribute("togo", "togo");
			
			ModelAndView menu = new ModelAndView("menu");
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
}
