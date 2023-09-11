package com.dev.OnlineStamp.model.exhibition;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="TB_EXHIBITION")
@Data
public class Exhibition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXHIBITION_ID")
	private Long id;
	
	@Column(name="EXHIBITION_NAME")
	private String name;
	
	@Column(name="EXHIBITION_SUBJECT")
	private String subject;
	
	@Column(name="EXHIBITION_AUTHOR")
	private String author;
	
	@Column(name="EXHIBITION_PRIZE_NAME")
	private String prizeName;
	
	@Column(name="EXHIBITION_AREA")
	private String area;
	
	@Column(name="EXHIBITION_EXPRIZE_NAME")
	private String exprizeName;
	
	@Transient
	private List<String> slideImages;
	
	@Transient
	private String firstImage;
	
	@Column(name="EXHIBITION_SORT")
	private Boolean sort;
	
	@Column(name="EXHIBITION_CHILDREN")
	private Boolean children;
	
	@Column(name="EXHIBITION_SIGN")
	private String sign;
	
	@OneToMany(
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "exhibitionId"
			)
	private List<ExhibitionImage> images;
	
}
