package com.stegan.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity // (name = "ImageDetails")
@Table(name = "IMAGE_DETAILS")
public class ImageMetaData {

	// @Column name to specify particular column name
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID")
	private int fileId;
	@Column(name = "FILE_NAME")
	@Lob // text in mssql, large object, CLOB(character lob)
	private String name;
	@Temporal(TemporalType.DATE) // add as date type in DB, default is timestamp
	private Date createdDate;
	private int fileSize;
	@Transient // don't include below as a column
	private String addedBy;
	@Embedded
	private Key key;
	@ElementCollection
	@JoinTable(name = "IMAGE_KEY", joinColumns = @JoinColumn(name = "IMAGE_ID"))
	@GenericGenerator(strategy = "org.hibernate.id.IncrementGenerator", name = "hilo-gen")
	@CollectionId(columns = { @Column(name="KEY_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Key> listKeys = new ArrayList<>();

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

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Collection<Key> getListKeys() {
		return listKeys;
	}

	public void setListKeys(Collection<Key> listKeys) {
		this.listKeys = listKeys;
	}
}
