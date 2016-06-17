package com.nsbdev.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "message")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private Long id;

	@Column(name = "create_date")
	@Temporal(value = TemporalType.DATE)
	private Date createDate;

	@Column(name = "message_id")
	private String messageId;

	@Type(type = "binary")
	@Column(length = 100000, name = "original_data")
	private byte[] originalData;

	@Type(type = "binary")
	@Column(length = 100000, name = "sign_key")
	private byte[] signKey;

	@Type(type = "binary")
	@Column(length = 100000, name = "encoded_data")
	private byte[] encodedData;

	public Message() {
		super();
	}

	public Message(Long id, Date createDate, String messageId, byte[] originalData, byte[] signKey, byte[] encodedData) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.messageId = messageId;
		
		this.originalData = originalData;
		this.signKey = signKey;
		this.encodedData = encodedData;
	}

	public Message(String messageId, byte[] originalData, byte[] signKey, byte[] encodedData) {
		super();
		this.messageId = messageId;
		this.originalData = originalData;
		this.signKey = signKey;
		this.encodedData = encodedData;
	}
	
	

	@Override
	public String toString() {
		return "Message [id=" + id + ", createDate=" + createDate + ", messageId=" + messageId + ", originalData="
				+ Arrays.toString(originalData) + ", key=" + Arrays.toString(signKey) + ", encodedData="
				+ Arrays.toString(encodedData) + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public byte[] getOriginalData() {
		return originalData;
	}

	public void setOriginalData(byte[] originalData) {
		this.originalData = originalData;
	}

	public byte[] getSignKey() {
		return signKey;
	}

	public void setSignKey(byte[] signKey) {
		this.signKey = signKey;
	}

	public byte[] getEncodedData() {
		return encodedData;
	}

	public void setEncodedData(byte[] encodedData) {
		this.encodedData = encodedData;
	}
	

}
