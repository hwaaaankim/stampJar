package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intro")
public class IntroController {
	
	@RequestMapping("/opening")
	public String opening() {
		
		return "front/intro/opening";
	}
	
	@RequestMapping("/history")
	public String history() {
		
		return "front/intro/history";
	}
	
	@RequestMapping("/introduction")
	public String introduction() {
		
		return "front/intro/introduction";
	}
	
	@RequestMapping("/symbol")
	public String symbol() {
		
		return "front/intro/symbol";
	}

}
