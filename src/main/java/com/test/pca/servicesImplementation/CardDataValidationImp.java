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
    public boolean validateCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName) {
        logger.info("validating card data");
        return bankCardRepository
                .existsBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(cardNumber,
                        cardCCV, bankClientEntity_fullName);
    }

    @Override
    public BankClientEntity getBankClientFromCardInfos(String cardNumber, int cardCCV,
                                                       String bankClientEntity_fullName) {
        logger.info("getting user data");
        BankClientEntity bankClientEntity = bankCardRepository
                .findBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(cardNumber,
                        cardCCV, bankClientEntity_fullName).getBankAccountEntity().getBankClientEntity();
        System.out.println(bankClientEntity);
        return bankClientEntity;
    }


}
