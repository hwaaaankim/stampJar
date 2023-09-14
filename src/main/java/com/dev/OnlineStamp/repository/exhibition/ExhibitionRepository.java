package com.dev.OnlineStamp.repository.exhibition;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.OnlineStamp.model.exhibition.Exhibition;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long>{

	Page<Exhibition> findAllBySortOrderByPrizeIndexAsc(Pageable pageable, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndSort(Pageable pageable, String subject, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndNameContainingAndSort(Pageable pageable,String subject, String name, Boolean sort);
	
	Page<Exhibition> findAllBySubjectAndAuthorContainingAndSort(Pageable pageable,String subject, String author, Boolean sort);
	
	Page<Exhibition> findAllByNameContainingAndSort(Pageable pageable, String name, Boolean sort);
	
	Page<Exhibition> findAllByAuthorContainingAndSort(Pageable pageable, String author, Boolean sort);
	
	List<Exhibition> findAllBySubjectAndSort(String subject, Boolean sort);
	
	Page<Exhibition> findAllByNameContainingOrAuthorContainingAndSubjectAndSort(Pageable pageable, 
			String name, String author, String subject, Boolean sort);
	
	Page<Exhibition> findAllByNameContainingOrAuthorContainingAndSort(Pageable pageable, 
			String name, String author, Boolean sort);
	
	List<Exhibition> findTop60BySort(Boolean sort);
}
