package br.com.bcp.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
	
	public Message<String> print(Message<String> message) {
		System.out.println(message.getPayload());
		int messageNumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("[1] Sending reply for message " + messageNumber).setHeader("aa", "bb").build();
	}

}
