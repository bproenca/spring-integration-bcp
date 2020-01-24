package br.com.bcp.integration;

import org.springframework.messaging.Message;

public class PrintService {
	
	public void print(Message<String> message) {
		throw new RuntimeException("## this is an error " + message.getPayload().substring(message.getPayload().length()-1) + " ##");
		//System.out.println(message.getPayload());
	}

}
