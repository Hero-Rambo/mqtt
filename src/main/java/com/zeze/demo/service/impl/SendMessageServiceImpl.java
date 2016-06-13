package com.zeze.demo.service.impl;


import io.netty.channel.ChannelId;



import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeze.demo.cache.repository.ChannelidRepository;
import com.zeze.demo.netty.ChannelMap;
import com.zeze.demo.service.SendMessageService;


@Service
public class SendMessageServiceImpl implements SendMessageService {

//	public static RabbitTemplate amqpTemplate = (RabbitTemplate) 
//			SpringServerContextsUtil.getBean("rabbitSendTemplate");
	
	RabbitTemplate rabbitTemplate = new RabbitTemplate();
	
	
	@Autowired
	ChannelidRepository channelidDao;
	
	@Override
	public String recvMsg(ChannelId id, Object msg) {
		saveChannelId("0007", id);
		System.out.println(msg);
		return "pong\r\n";
	}

	@Override
	public String saveChannelId(String did, ChannelId id) {
		ChannelMap.add(did, id);
		return null;
	}

	@Override
	public void sendData(Object obj) {
//		amqpTemplate.convertAndSend(obj);
	}
	
}
