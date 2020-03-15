package br.com.bcp.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;

public class PrintService {
	
	public void print(Message<?> message) {
		//throw new RuntimeException("## this is an error " + message.getPayload().substring(message.getPayload().length()-1) + " ##");
		System.out.println(message.getPayload());
		
		for (Entry<String, Object> entry : message.getHeaders().entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
