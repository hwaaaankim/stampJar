package com.dev.OnlineStamp.repository.exhibition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.OnlineStamp.model.exhibition.Exhibition;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>{

	Page<Exhibition> findAll(Pageable pageable);
	
	Page<Exhibition> findAllBySubject(Pageable pageable, String subject);
	
	Page<Exhibition> findAllBySubjectAndNameContaining(Pageable pageable,String subject, String name);
	
	Page<Exhibition> findAllBySubjectAndAuthorContaining(Pageable pageable,String subject, String author);
	
	Page<Exhibition> findAllByNameContaining(Pageable pageable, String name);
	
	Page<Exhibition> findAllByAuthorContaining(Pageable pageable, String author);
}
