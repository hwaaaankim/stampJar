package com.dev.OnlineStamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
			@RequestParam(required = false, defaultValue = "") String searchWord
			) {
		Page<Exhibition> exhibitions = null;
		if("all".equals(subject) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySort(pageable, true);
			
		}else if(!"all".equals(subject) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySubjectAndSort(pageable, subject, true);
			
		}else if(!"all".equals(subject) && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllByNameContainingOrAuthorContainingAndSubjectAndSort(pageable, searchWord, searchWord, subject, true);
			
		}else if("all".equals(subject)  && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllByNameContainingOrAuthorContainingAndSort(pageable, searchWord, searchWord, true);
			
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
		model.addAttribute("subject", subject);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("exhibitions", exhibitions);
		return "front/contest/excellent";
	}
	
	@RequestMapping("/excellentDetail/{id}")
	public String excellentDetail(
			@PathVariable Long id,
			Model model
			) {
		Exhibition ex = exhibitionRepository.findById(id).get();
		List<Exhibition> re = exhibitionRepository.findAllBySubjectAndSort(ex.getSubject(), true);
		model.addAttribute("ex", ex);
		if(re.size()>0) {
			for(Exhibition e : re) {
				ArrayList<String> images = new ArrayList<>();
				for(int a=1; a<4; a++) {
					images.add(e.getImages().get(a).getImageRoad());
				}
				e.setFirstImage(e.getImages().get(0).getImageRoad());
				e.setSlideImages(images);
			}
		}
		model.addAttribute("re", re);
		return "front/contest/excellentDetail";
	}
	
	@RequestMapping("/normal")
	public String normal(Model model,
			@PageableDefault(size = 12) Pageable pageable,
			@RequestParam(required = false, defaultValue = "all") String subject,
			@RequestParam(required = false, defaultValue = "") String searchWord
			) {
		
		Page<Exhibition> exhibitions = null;
		if("all".equals(subject) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySort(pageable, false);
			
		}else if(!"all".equals(subject) && "".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllBySubjectAndSort(pageable, subject, false);
			
		}else if(!"all".equals(subject) && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllByNameContainingOrAuthorContainingAndSubjectAndSort(pageable, searchWord, searchWord, subject, false);
			
		}else if("all".equals(subject)  && !"".equals(searchWord)) {
			exhibitions = exhibitionRepository.findAllByNameContainingOrAuthorContainingAndSort(pageable, searchWord, searchWord, false);
			
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
		model.addAttribute("subject", subject);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("exhibitions", exhibitions);
		return "front/contest/normal";
	}
	
	@RequestMapping("/normalDetail/{id}")
	public String normalDetail(@PathVariable Long id,
			Model model
			) {
		Exhibition ex = exhibitionRepository.findById(id).get();
		List<Exhibition> re = exhibitionRepository.findAllBySubjectAndSort(ex.getSubject(), true);
		model.addAttribute("ex", ex);
		if(re.size()>0) {
			for(Exhibition e : re) {
				ArrayList<String> images = new ArrayList<>();
				for(int a=1; a<4; a++) {
					images.add(e.getImages().get(a).getImageRoad());
				}
				e.setFirstImage(e.getImages().get(0).getImageRoad());
				e.setSlideImages(images);
			}
		}
		model.addAttribute("re", re);
		return "front/contest/normalDetail";
	}
}
