package com.test.pca;

import com.test.pca.entities.BankAccountEntity;
import com.test.pca.entities.BankCardEntity;
import com.test.pca.entities.BankClientEntity;
import com.test.pca.enums.AccountCurrency;
import com.test.pca.enums.AccountType;
import com.test.pca.repositories.BankAccountRepository;
import com.test.pca.repositories.BankCardRepository;
import com.test.pca.repositories.BankClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;
import java.util.GregorianCalendar;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(BankAccountRepository bankAccountRepository,
                                         BankClientRepository bankClientRepository, BankCardRepository bankCardRepository) {
        return args -> {
            Calendar date = new GregorianCalendar(2020, 2, 10);
            // create new clients
            BankClientEntity user = new BankClientEntity("anas", "rafa0anas@gmail.com", "056156156", date, "564564466465");
            BankClientEntity user1 = new BankClientEntity("anaas", "rafaoo0anas@gmail.com", "06565565", date, "564564466465");
            // save the client
            bankClientRepository.save(user);
            bankClientRepository.save(user1);
            //create new accounts
            BankAccountEntity account1 = new BankAccountEntity(4644647486L,AccountType.COURANT, AccountCurrency.MAD,
             158.25f, 564646454L, "rabat" , user);
			BankAccountEntity account2 = new BankAccountEntity(4644622346L,AccountType.INTERNECREDIT,
                    AccountCurrency.EUR,
					158.25f, 564646454L, "casa" , user);
			BankAccountEntity account3 = new BankAccountEntity(4644647480L,AccountType.COURANT, AccountCurrency.MAD,
					158.25f, 564646454L, "rabat" , user1);
            bankAccountRepository.save(account1);
            bankAccountRepository.save(account2);
            bankAccountRepository.save(account3);
            // create and save new pages
			BankCardEntity card1=new BankCardEntity("45444641213", date, date , 45452312,account1);
			BankCardEntity card2=new BankCardEntity("45444644897", date, date , 45455578,account2);
			BankCardEntity card3=new BankCardEntity("45444644788", date, date , 45456847,account3);
			BankCardEntity card4=new BankCardEntity("45444644566", date, date , 45450201,account1);

			bankCardRepository.save(card1);
			bankCardRepository.save(card2);
			bankCardRepository.save(card3);
			bankCardRepository.save(card4);




		};
    }

}
