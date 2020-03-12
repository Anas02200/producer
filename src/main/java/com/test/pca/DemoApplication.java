package com.test.pca;

import com.test.pca.entities.CardDataEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.pca.entities.UserEntity;
import com.test.pca.repositories.CardHoldersRepository;
import com.test.pca.repositories.CardsRepository;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Bean
	    public CommandLineRunner mappingDemo(CardHoldersRepository cardHoldersRepository,
	                                         CardsRepository cardsRepository) {
	        return args -> {

	            // create a new book
	            UserEntity user = new UserEntity("anaas","anaaas");
				UserEntity user1 = new UserEntity("anaas","anaaas");
	            // save the book
				cardHoldersRepository.save(user);
				cardHoldersRepository.save(user1);
	            // create and save new pages
				cardsRepository.save(new CardDataEntity("cardNumber0", 04, 25, 2027, 985, user));
				cardsRepository.save(new CardDataEntity("cardNumber1", 05, 26, 2027, 975, user));
				cardsRepository.save(new CardDataEntity("cardNumber2", 06, 27, 2027, 965, user));
				cardsRepository.save(new CardDataEntity("cardNumber72", 06, 27, 2027, 777, user1));
				cardsRepository.save(new CardDataEntity("cardNumber12", 06, 777, 20227, 965, user1));
	        };
	    }

}
