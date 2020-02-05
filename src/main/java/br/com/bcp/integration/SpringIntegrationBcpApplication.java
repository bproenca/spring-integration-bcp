package br.com.bcp.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationBcpApplication implements ApplicationRunner{

	@Autowired
	private PrinterGateway gateway;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationBcpApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 10; i++) {
			//Message<String> message = MessageBuilder.withPayload("Printing message payload for " + i).build();
			Message<?> message = MessageBuilder.withPayload(i).build();
			gateway.print(message);
		}		
	}

}
