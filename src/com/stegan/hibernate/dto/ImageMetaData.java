package com.stegan.hibernate.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity//(name = "ImageDetails")
@Table(name = "IMAGE_DETAILS")
public class ImageMetaData {

	//@Column name to specify particular column name
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private int fileId;
	@Column(name = "FILE_NAME")
	@Lob   // text in mssql, large object, CLOB(character lob)
	private String name;
	@Temporal(TemporalType.DATE) // add as date type in DB, default is timestamp
	private Date createdDate;
	private int fileSize;
	@Transient //don't include below as a column
	private String addedBy;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	// @Column can be added on getter as well
	// @Column(name = "FILE_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
}
