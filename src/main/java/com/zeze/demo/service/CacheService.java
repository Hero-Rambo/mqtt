package com.zeze.demo.service;

import com.zeze.demo.cache.mapper.MqttClientMapper;

public interface CacheService {

	public String saveMqttClient(MqttClientMapper mqttClientMapper);
	
	public MqttClientMapper getMqttClientByUserName(String userName);
	
	public String set(String key, Object value);
	
	public Object get(String key);
	
	public String remove(String key);
}
