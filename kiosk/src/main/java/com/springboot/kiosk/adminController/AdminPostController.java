package com.springboot.kiosk.adminController;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	public int insertFood(FoodDTO food, 
			@RequestParam("img") MultipartFile file,
			MultipartHttpServletRequest request
			) {
		String fileName = file.getOriginalFilename();
		food.setImg(fileName);
		
		ServletContext ctx = request.getServletContext();
		String uploadPath = "resources/productImg";
		String path = ctx.getRealPath(uploadPath);
		File saveFile = new File(path, file.getOriginalFilename());
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int result = fService.insertFood(food);
		
		return result;
	}
	
	@PostMapping("/login")
	public int login(@RequestBody AdminDTO admin) {
		int result = aService.login(admin);
		
		return result;
	}
}
