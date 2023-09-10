package com.dev.OnlineStamp.model.exhibition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_EXHIBITION")
@Data
public class Exhibition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXHIBITION_ID")
	private Long id;
	
	@Column(name="EXHIBITION_TITLE")
	private String title;
}
