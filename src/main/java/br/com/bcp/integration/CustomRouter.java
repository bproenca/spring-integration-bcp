package br.com.bcp.integration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class CustomRouter extends AbstractMessageRouter {

	@Autowired
	@Qualifier("intChannel")
	private MessageChannel intChannnel;

	@Autowired
	@Qualifier("strChannel")
	private MessageChannel strChannnel;
	
	@Override
	protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
		Collection<MessageChannel> targetChannels = new ArrayList<MessageChannel>();
		
		if (message.getPayload().getClass().equals(Integer.class)) {
			targetChannels.add(intChannnel);
		} else if (message.getPayload().getClass().equals(String.class)) {
			targetChannels.add(strChannnel);
		}
		
		return targetChannels;
	}

}
