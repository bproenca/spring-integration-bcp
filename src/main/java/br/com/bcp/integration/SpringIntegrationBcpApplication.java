package br.com.bcp.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

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
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();
		
		for (int i = 0; i < 10; i++) {
			Message<String> message = MessageBuilder
					.withPayload("Printing message payload for " + i)
					.setHeader("messageNumber", i)
					.setPriority(i)
					.build();
			System.out.println("[0] Sending message " + i);
			futures.add(gateway.print(message));
		}
		
		for (Future<Message<String>> future : futures) {
			System.out.println("[2]" + future.get().getPayload());
		}
		
		System.out.println("done");
	}

}
