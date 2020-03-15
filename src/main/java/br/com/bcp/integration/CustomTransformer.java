package br.com.bcp.integration;

import org.springframework.messaging.Message;

public class CustomTransformer {

	public String transform(Message<String> msg) {
		String[] tokens = msg.getPayload().split(" ");
		return tokens[1] + ", " + tokens[0];
	}
}
