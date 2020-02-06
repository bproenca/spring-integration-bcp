package br.com.bcp.integration;

import org.springframework.messaging.Message;

public class DefaultPrintService {
	
	public void print(Message<?> message) {
		System.out.println("Printing from the default service " + message.getPayload());
	}

}