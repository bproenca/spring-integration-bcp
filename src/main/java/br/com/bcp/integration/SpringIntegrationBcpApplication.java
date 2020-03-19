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
		Person[] payloads = {new Person("bruno", "henrique"), new Person("felipe", "gabriel"), new Person("duda", "proenca")};
		for (int i = 0; i < payloads.length; i++) {
			Message<?> message = MessageBuilder.withPayload(payloads[i]).setHeader("replyChannel", "outputChannel").build();
			gateway.print(message);
		}		
	}

}
