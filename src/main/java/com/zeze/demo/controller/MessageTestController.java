package com.zeze.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zeze.demo.service.SendMessageService;

@Controller
public class MessageTestController {

	@Autowired
	SendMessageService sendMessageService;
	
	@RequestMapping(value="/msg/test", method = RequestMethod.GET)
	@ResponseBody
	public String testRabbit() {
		
		sendMessageService.sendData("hello message!");
		return null;
	}
	
}
