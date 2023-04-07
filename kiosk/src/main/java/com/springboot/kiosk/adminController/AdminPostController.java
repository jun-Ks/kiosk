package com.springboot.kiosk.adminController;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.kiosk.dto.AdminDTO;
import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IAdminService;
import com.springboot.kiosk.service.IFoodService;


@RestController
@RequestMapping("/admin")

public class AdminPostController {
	
	@Autowired
	IFoodService fService;
	
	@Autowired
	IAdminService aService;
	
	@Autowired
	FoodDTO food;
	
	@PostMapping("/food")
	public ModelAndView insertFood(FoodDTO food, 
			@RequestParam("productImg") MultipartFile file,
			MultipartHttpServletRequest request,
			Model model
			) {
		String fileName = file.getOriginalFilename();
		
		ServletContext ctx = request.getServletContext();
		String uploadPath = "resources/productImg";
		String path = ctx.getRealPath(uploadPath);
		File saveFile = new File(path, file.getOriginalFilename());
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		food.setImg(fileName);
		int result = fService.insertFood(food);
		if(result == 1) {
			String msg = "등록성공!";
			model.addAttribute("msg", msg);
			ModelAndView productList = new ModelAndView("/admin/productList");
			
			return productList;
		}else {
			String msg = "등록실패....";
			model.addAttribute("등록실패....", "msg");
			ModelAndView productRegist = new ModelAndView("/admin/productRegist");
			
			return productRegist;
		}
	}
	
	@PostMapping("/login")
	public int login(@RequestBody AdminDTO admin) {
		int result = aService.login(admin);
		
		return result;
	}
}
