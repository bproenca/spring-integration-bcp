package br.com.bcp.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationBcpApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationBcpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Message<String> message = MessageBuilder
				.withPayload("Message builder")
				.setHeader("headerName", "headerValue").build();
		PrintService service = new PrintService();
		service.print(message);
	}

}
