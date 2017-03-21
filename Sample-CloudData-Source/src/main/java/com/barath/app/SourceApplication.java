package com.barath.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class SourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourceApplication.class, args);
	}
	
	@Bean
	@InboundChannelAdapter(
	  value = Source.OUTPUT, 
	  poller= @org.springframework.integration.annotation.Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
	)
	public MessageSource<Long> timeMessageSource() {
	    return () -> MessageBuilder.withPayload(new Date().getTime()).build();
	}
}
