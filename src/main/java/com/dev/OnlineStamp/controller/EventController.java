package com.dev.OnlineStamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {

	
	@RequestMapping("/comment")
	public String comment() {
		
		return "front/event/comment";
	}
	
	@RequestMapping("/eventOne")
	public String eventOne() {
		
		return "front/event/eventOne";
	}
	
	@RequestMapping("/eventTwo")
	public String eventTwo() {
		
		return "front/event/eventTwo";
	}
	
	@RequestMapping("/eventThree")
	public String eventThree() {
		
		return "front/event/eventThree";
	}
	
	@RequestMapping("/prize")
	public String prize() {
		
		return "front/event/prize";
	}
}
