package com.springboot.kiosk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
	@GetMapping("/index")
	public void index() {
		
	}

	@GetMapping("/admin/adminPage")
	public void adminPage() {
		
	}

}
