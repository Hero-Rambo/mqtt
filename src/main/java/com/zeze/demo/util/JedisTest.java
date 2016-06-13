package com.zeze.demo.util;


import com.zeze.demo.cache.mapper.ClientMapper;
import com.zeze.demo.mqtt.MqttStaticUtil;

import redis.clients.jedis.Jedis;

public class JedisTest {

//	private static Properties properties = new Properties();
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("192.168.12.196");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.print(value);
		
		ClientMapper clientMapper = new ClientMapper();
		clientMapper.setClientId("java test");
		clientMapper.setChannelId(null);
		clientMapper.setKeepAliveTimeSeconds(10);
		jedis.set("hello object".getBytes(), 
				SerializeUtil.serialize(clientMapper));
		
		byte[] bt = jedis.get("hello object".getBytes());
		ClientMapper clientMapperR = (ClientMapper) SerializeUtil.unserialize(bt);
	}
	
}
