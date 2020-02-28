package com.test.pca.kafkaService;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannel {

	String out="out";
	
	@Output(out)
	MessageChannel out();
}
