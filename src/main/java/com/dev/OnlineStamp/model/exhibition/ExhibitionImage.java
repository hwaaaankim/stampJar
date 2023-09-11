package com.dev.OnlineStamp.model.exhibition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TB_EXHIBITION_IMAGE")
@Data
public class ExhibitionImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMAGE_ID")
	private Long id;
	
	@Column(name="IMAGE_REFER_ID")
	private Long exhibitionId;
	
	@Column(name="IMAGE_PATH")
	private String imagePath;
	
	@Column(name="IMAGE_NAME")
	private String imageName;
	
	@Column(name="IMAGE_ROAD")
	private String imageRoad;
}
