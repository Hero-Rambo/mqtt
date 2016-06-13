package com.zeze.demo.cache.mapper;

import java.io.Serializable;

public 	class SubMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String publishId;
	private Integer pubQos;
	
	public String getPublishId() {
		return publishId;
	}
	public void setPublishId(String publishId) {
		this.publishId = publishId;
	}
	public Integer getPubQos() {
		return pubQos;
	}
	public void setPubQos(Integer pubQos) {
		this.pubQos = pubQos;
	}
	
}