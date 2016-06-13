package com.zeze.demo.cache.mapper;

import java.io.Serializable;

public class SubTopics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String topicName;
	private Integer subQos;
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public Integer getSubQos() {
		return subQos;
	}
	public void setSubQos(Integer subQos) {
		this.subQos = subQos;
	}
	
}
