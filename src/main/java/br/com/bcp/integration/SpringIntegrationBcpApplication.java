package br.com.bcp.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationBcpApplication implements ApplicationRunner{

	@Autowired
	@Qualifier("inputChannel")
	private DirectChannel inputChannel;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationBcpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Message<String> message = MessageBuilder
				.withPayload("Message builder")
				.setHeader("headerName", "headerValue").build();		
		
		MessagingTemplate template = new MessagingTemplate();
		Message<?> receive = template.sendAndReceive(inputChannel, message);
		System.out.println(receive.getPayload());
	}

}
