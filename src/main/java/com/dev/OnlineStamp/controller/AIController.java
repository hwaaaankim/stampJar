package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ai")
public class AIController {

	@RequestMapping("/prompt")
	public String prompt() {
		
		return "front/ai/index";
	}
	
	@RequestMapping("/start")
	public String start() {
		
		return "front/ai/start";
	}
}
