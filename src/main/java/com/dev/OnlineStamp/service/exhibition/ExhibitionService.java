package com.dev.OnlineStamp.service.exhibition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.OnlineStamp.repository.exhibition.ExhibitionRepository;

@Service
public class ExhibitionService {

	@Autowired
	ExhibitionRepository exhibitionRepository;
}
