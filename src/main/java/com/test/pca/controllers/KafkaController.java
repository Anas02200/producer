package com.test.pca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.pca.entities.UserEntity;
import com.test.pca.kafkaService.KafkaProducer;

@RestController
@RequestMapping(value = "kafka")
public class KafkaController {
	private final KafkaProducer producer;

	@Autowired
	public KafkaController(KafkaProducer producer) {

		this.producer = producer;
	}
	/*
	 * @PostMapping(value="/publish") public void
	 * sendMessage(@RequestParam("message") String message) {
	 * 
	 * this.producer.sendMessage(message); }
	 */

	/*
	 * @PostMapping(value="/publish") public void sendMessage(@RequestBody
	 * UserEntity user) {
	 * 
	 * this.producer.sendMessage(user); }
	 */
	
}
