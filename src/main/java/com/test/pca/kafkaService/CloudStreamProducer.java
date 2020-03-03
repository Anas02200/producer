package com.test.pca.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;

import com.test.pca.entities.UserEntity;



@EnableBinding(ProducerChannel.class)
public class CloudStreamProducer {
	private static final Logger logger=LoggerFactory.getLogger(CloudStreamProducer.class);
	private final MessageChannel consumer;

	public CloudStreamProducer(ProducerChannel channel) {
		this.consumer = channel.out();
	}

	@Scheduled(fixedRate = 5000)
	public void send() {
		
		UserEntity user = new UserEntity("mee", 56456456);
		Message<UserEntity> message = MessageBuilder.withPayload(user).build();
		this.consumer.send(message);
		logger.info(String.format("PRODUCING MESSAGE ==> %s", message));

	}
}
