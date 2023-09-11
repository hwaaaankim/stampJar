package com.dev.OnlineStamp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev.OnlineStamp.model.exhibition.Exhibition;
import com.dev.OnlineStamp.repository.exhibition.ExhibitionRepository;

@Controller
@RequestMapping("/contest")
public class ContestController {

	
	@Autowired
	ExhibitionRepository exhibitionRepository;
	
	
	@RequestMapping("/excellent")
	public String excellent(
			Model model,
			@PageableDefault(size = 12) Pageable pageable,
			@RequestParam(required = false, defaultValue = "all") String subject,
			@RequestParam(required = false, defaultValue = "") String searchType,
			@RequestParam(required = false, defaultValue = "") String searchWord
			) {
		
//		Page<Exhibition> exhibitions = exhibitionRepository.findAll(pageable);
		Page<Exhibition> exhibitions = null;
		if("all".equals(subject) && "".equals(searchType) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySort(pageable, true);
			
		}else if(!"all".equals(subject) && "".equals(searchType) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySubjectAndSort(pageable, subject, true);
			
		}else if(!"all".equals(subject) && !"".equals(searchType) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySubjectAndSort(pageable, subject, true);
			
		}else if(!"all".equals(subject) && "".equals(searchType) && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySubjectAndSort(pageable, subject, true);
			
		}else if(!"all".equals(subject) && !"".equals(searchType) && !"".equals(searchWord)) {
			if("name".equals(searchType)) {
				exhibitions = exhibitionRepository.findAllBySubjectAndSortAndNameContaining(pageable, subject, searchWord, true);
			}else if("author".equals(searchType)) {
				exhibitions = exhibitionRepository.findAllBySubjectAndSortAndAuthorContaining(pageable, subject, searchWord, true);
			}
		}else if("all".equals(subject) && !"".equals(searchType) && !"".equals(searchWord)) {
			if("name".equals(searchType)) {
				exhibitions = exhibitionRepository.findAllByNameContainingAndSort(pageable, searchWord, true);
				
			}else if("author".equals(searchType)) {
				exhibitions = exhibitionRepository.findAllByAuthorContainingAndSort(pageable, searchWord, true);
				
			}
			
		}else if("all".equals(subject) && "".equals(searchType) && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAll(pageable);
		}
		
		
		if(exhibitions.getNumberOfElements()>0) {
			for(Exhibition e : exhibitions) {
				ArrayList<String> images = new ArrayList<>();
				for(int a=1; a<4; a++) {
					images.add(e.getImages().get(a).getImageRoad());
				}
				e.setFirstImage(e.getImages().get(0).getImageRoad());
				e.setSlideImages(images);
			}
		}
		
		
		int startPage = Math.max(1, exhibitions.getPageable().getPageNumber() - 4);
		int endPage = Math.min(exhibitions.getTotalPages(), exhibitions.getPageable().getPageNumber() + 4);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("exhibitions", exhibitions);
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
