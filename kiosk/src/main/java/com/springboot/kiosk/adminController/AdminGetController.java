package com.springboot.kiosk.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminGetController {
	
	@GetMapping("/adminPage")
	public ModelAndView adminPage() {
		ModelAndView adminPage = new ModelAndView("/admin/adminPage");
		
		return adminPage;
	}
}
