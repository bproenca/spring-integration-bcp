package br.com.bcp.integration;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
	
	public void print(Message<String> message) {
		System.out.println(message.getPayload());
		MessageHeaders headers = message.getHeaders();
		System.out.println(headers);
	}

}
