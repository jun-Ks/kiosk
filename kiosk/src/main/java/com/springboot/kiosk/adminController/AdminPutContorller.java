package com.springboot.kiosk.adminController;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springboot.kiosk.dto.FoodDTO;
import com.springboot.kiosk.service.IFoodService;

@RestController
@RequestMapping("/admin")
public class AdminPutContorller {
	
	@Autowired
	IFoodService fService;
	
	//제품수정
	@PutMapping("/products/list/u/{code}")
	public int productUpdate(@PathVariable int code, 
			@RequestBody FoodDTO food, 
			@RequestParam("productImg") MultipartFile file,
			MultipartHttpServletRequest request
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
		int result = fService.updateProduct(code, food);
		
		return result;
	}
}
