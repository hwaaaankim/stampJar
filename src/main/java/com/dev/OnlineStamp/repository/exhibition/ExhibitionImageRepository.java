package com.dev.OnlineStamp.repository.exhibition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.OnlineStamp.model.exhibition.ExhibitionImage;

@Repository
public interface ExhibitionImageRepository extends JpaRepository<ExhibitionImage, Long>{

}
