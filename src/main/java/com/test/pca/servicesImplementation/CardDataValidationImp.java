package com.test.pca.servicesImplementation;

import com.test.pca.entities.BankClientEntity;
import com.test.pca.repositories.BankCardRepository;
import com.test.pca.repositories.BankClientRepository;
import com.test.pca.services.CardDataValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CardDataValidationImp implements CardDataValidation {
    private static final Logger logger = LoggerFactory.getLogger(CardDataValidationImp.class);
    private final BankCardRepository bankCardRepository;
    private final BankClientRepository bankClientRepository;

    public CardDataValidationImp(BankCardRepository bankCardRepository, BankClientRepository bankClientRepository) {
        this.bankCardRepository = bankCardRepository;
        this.bankClientRepository = bankClientRepository;
    }


    @Override
    public boolean validateCardInfos(String bankClientEntity_fullName, String cardNumber, int cardCCV) {
        logger.info("validating card data");
        return bankCardRepository.existsBankCardEntityByBankClientEntity_FullNameAndCardNumberAndCardCCV(bankClientEntity_fullName, cardNumber, cardCCV);
    }

    @Override
    public BankClientEntity getBankClientFromCardInfos(String bankClientEntity_fullName, String cardNumber, int cardCCV) {
        logger.info("getting user data");
        BankClientEntity bankClientEntity = bankCardRepository.findBankCardEntityByBankClientEntity_FullNameAndCardNumberAndCardCCV(bankClientEntity_fullName, cardNumber, cardCCV).getBankClientEntity();
        System.out.println(bankClientEntity);
        return bankClientEntity;
    }
}
