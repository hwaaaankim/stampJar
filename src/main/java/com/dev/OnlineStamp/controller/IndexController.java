package com.dev.OnlineStamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.OnlineStamp.model.exhibition.Exhibition;
import com.dev.OnlineStamp.repository.exhibition.ExhibitionRepository;

@Controller
public class IndexController {

	@Autowired
	ExhibitionRepository exhibitionRepository;
	
	@RequestMapping({"/index","/"})
	public String index(Model model) {
		
		List<Exhibition> exhibitions = exhibitionRepository.findTop60BySort(false);
		if(exhibitions.size()>0) {
			for(Exhibition e : exhibitions) {
				e.setFirstImage(e.getImages().get(0).getImageRoad());
			}
		}
		List<List<Exhibition>> ex = new ArrayList<List<Exhibition>>();
		List<Exhibition> temp = new ArrayList<Exhibition>();
		int idx=1;
		int cnt=0;
		int size=3;
		for(int x=0; x<exhibitions.size(); x++) {
			if((x%3) == 0 && x!=0) {
				ex.add(exhibitions.subList(cnt, size));
				cnt=idx * 3;
				size=(idx+1) * 3;
				idx++;
			}
		}
		model.addAttribute("ex", ex);
		return "front/index";
	}
}
