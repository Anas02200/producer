package com.test.pca.servicesImplementation;

import com.test.pca.entities.BankClientEntity;
import com.test.pca.services.ProducerChannel;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;



@EnableBinding(ProducerChannel.class)
public class KafkaProducerService {
	private static final Logger logger=LoggerFactory.getLogger(KafkaProducerService.class);
	private final MessageChannel consumer;

	public KafkaProducerService(@NotNull ProducerChannel channel) {
		this.consumer = channel.out();
	}

	@Scheduled(fixedRate = 10000)
	public void send() {
		
		BankClientEntity user = new BankClientEntity();
		Message<BankClientEntity> message = MessageBuilder.withPayload(user).build();
		this.consumer.send(message);
		logger.info(String.format("PRODUCING MESSAGE ==> %s", message));

	}
}
