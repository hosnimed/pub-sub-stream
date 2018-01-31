package com.sbm.cloud.stream.reactive;

import com.sbm.cloud.stream.reactive.integration.OutputChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.atomic.AtomicInteger;

@EnableBinding(OutputChannel.class)
@SpringBootApplication
public class PublisherApplication {

	private Environment environment;
	private AtomicInteger count = new AtomicInteger(100);

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@Bean
	@InboundChannelAdapter(value = OutputChannel.SOURCE, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
	public MessageSource<String> timerMessageSource() {
		final String profile = environment.getActiveProfiles()[0];
		return new MessageSource<String>() {
			public Message<String> receive() {
				System.out.println("******************");
				System.out.println("At the Publisher");
				System.out.println("******************");
				String value = "hello from " +profile+ " : "+count.getAndIncrement();
				System.out.println("Sending value: " + value);
				return MessageBuilder.withPayload(value).build(); //setHeader(MessageHeaders.CONTENT_TYPE, "application/json").build();
			}
		};
	}

	@Autowired
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
