package br.com.bcp.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
	
	public Message<String> print(Message<String> message) {
		System.out.println(message.getPayload());
		MessageHeaders headers = message.getHeaders();
		System.out.println(headers);
		
		return MessageBuilder.withPayload("Return Message").setHeader("aa", "bb").build();
	}

}
