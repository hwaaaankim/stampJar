package com.dev.OnlineStamp.repository.exhibition;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.OnlineStamp.model.exhibition.Exhibition;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>{

	Page<Exhibition> findAllBySort(Pageable pageable, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndSort(Pageable pageable, String subject, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndSortAndNameContaining(Pageable pageable,String subject, String name, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndSortAndAuthorContaining(Pageable pageable,String subject, String author, Boolean sort);
	
	Page<Exhibition> findAllByNameContainingAndSort(Pageable pageable, String name, Boolean sort);
	
	Page<Exhibition> findAllByAuthorContainingAndSort(Pageable pageable, String author, Boolean sort);
	
	List<Exhibition> findAllBySubjectAndSort(String subject, Boolean sort);
}
