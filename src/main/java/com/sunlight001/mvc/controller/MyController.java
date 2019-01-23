package com.sunlight001.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@RequestMapping("/mytest")
	public String testMy() {
		return "test";
	}

}
