package com.zeze.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

import com.zeze.demo.cache.mapper.MqttClientMapper;
import com.zeze.demo.cache.repository.MqttClientRepository;
import com.zeze.demo.service.CacheService;
import com.zeze.demo.util.SerializeUtil;

@Service
public class CacheServiceImpl implements CacheService {

	private static Jedis jedis = new Jedis("192.168.12.196");
	
	@Autowired
	MqttClientRepository mqttClientDao;
	
	@Override
	public String saveMqttClient(MqttClientMapper mqttClientMapper) {
		
		MqttClientMapper mqttClientMapperNew = mqttClientDao.save(mqttClientMapper);
		return mqttClientMapperNew.toString();
	}

	@Override
	public MqttClientMapper getMqttClientByUserName(String userName) {
		
		MqttClientMapper mqttClientMapperNew = mqttClientDao.findOne(userName);
		return mqttClientMapperNew;
	}

	@Override
	public String set(String key, Object value) {
		String result = jedis.set(key.getBytes(), 
				SerializeUtil.serialize(value));
		return result;
	}

	@Override
	public Object get(String key) {
		byte[] value = jedis.get(key.getBytes());
		Object result = SerializeUtil.unserialize(value);
		return result;
	}

	@Override
	public String remove(String key) {
		
		Long result = jedis.del(key.getBytes());
		return result.toString();
	}

}
