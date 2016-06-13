package com.zeze.demo.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqTest {

	
	public static void main(String[] arg) throws IOException, TimeoutException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("192.168.12.195");
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("123456");
		Connection connection = connectionFactory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    channel.queueDeclare("myQueue", false, false, false, null);
	    String message = "Hello World!";
	    channel.basicPublish("", "myQueue", null, message.getBytes());
	    System.out.println(" [x] Sent '" + message + "'");
	}
}
