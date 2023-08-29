package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class InformationController {

	
	@RequestMapping("/contact")
	public String contact() {
		
		return "front/information/contact";
	}
	
	@RequestMapping("/process")
	public String process() {
		
		return "front/information/process";
	}
	
	@RequestMapping("/program")
	public String program() {
		
		return "front/information/program";
	}
}
