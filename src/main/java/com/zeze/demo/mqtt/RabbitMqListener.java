package com.zeze.demo.mqtt;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;


public class RabbitMqListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		
		System.out.println(arg0);
	}

}
