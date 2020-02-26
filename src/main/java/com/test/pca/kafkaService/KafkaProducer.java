package com.test.pca.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.test.pca.entities.UserEntity;
@EnableScheduling
@Service
public class KafkaProducer {

	private static final Logger logger=LoggerFactory.getLogger(KafkaProducer.class);
	private static final String TOPIC="user_scores";
	
	@Autowired
	private KafkaTemplate<String, UserEntity> kafkaTemplate;
	
	
	public void sendMessage(UserEntity message) {
		logger.info(String.format("PRODUCING MESSAGE ==> %s", message));
		
		this.kafkaTemplate.send(TOPIC, String.valueOf(Math.random()), message);
		
	}
	@Scheduled(fixedRate = 1000)
	public void sendMessage() {
		UserEntity message = new UserEntity();
		logger.info(String.format("PRODUCING MESSAGE ==> "+ message.getCardNumber(), message.getName()));
		this.kafkaTemplate.send(TOPIC, String.valueOf(Math.random()), message);
		
	}
	
	/*public void sendMessage(String message) {
		logger.info(String.format("PRODUCING MESSAGE ==> %s", message));
		//this.kafkaTemplate.send(TOPIC,message);
	}*/
	/*private long counter = 0;
	@Scheduled(fixedRate = 5)
    public void produce() {
        System.out.println("Produced :: " + counter);
        this.kafkaTemplate.send(TOPIC,counter++);
    }*/
	
}
