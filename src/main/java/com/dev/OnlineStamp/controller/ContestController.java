package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contest")
public class ContestController {

	@RequestMapping("/excellent")
	public String excellent() {
		
		
		return "front/contest/excellent";
	}
	
	@RequestMapping("/excellentDetail")
	public String excellentDetail() {
		
		
		return "front/contest/excellentDetail";
	}
	
	@RequestMapping("/normal")
	public String normal() {
		
		
		return "front/contest/normal";
	}
	
	@RequestMapping("/normalDetail")
	public String normalDetail() {
		
		
		return "front/contest/normalDetail";
	}
}
