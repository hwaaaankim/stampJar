package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@RequestMapping("/content")
	public String content() {
		
		return "front/notice/content";
	}
	
	@RequestMapping("/gallery")
	public String gallery() {
		
		return "front/notice/gallery";
	}
	
	@RequestMapping("/press")
	public String symbol() {
		
		return "front/notice/press";
	}
}
