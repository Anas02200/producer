package com.test.pca.servicesImplementation;

import com.test.pca.dataTransferObject.BankingInfosDto;
import com.test.pca.entities.BankCardEntity;
import com.test.pca.entities.BankClientEntity;
import com.test.pca.repositories.BankCardRepository;
import com.test.pca.repositories.BankClientRepository;
import com.test.pca.services.CardDataValidation;
import com.test.pca.services.MapBankInfosToDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Log
@Service
public class CardDataValidationImp implements CardDataValidation {

    private final BankCardRepository bankCardRepository;
    private final BankClientRepository bankClientRepository;
    private final MapBankInfosToDto mapBankInfosToDto;

    public CardDataValidationImp(BankCardRepository bankCardRepository, BankClientRepository bankClientRepository,
                                 MapBankInfosToDto mapBankInfosToDto) {
        this.bankCardRepository = bankCardRepository;
        this.bankClientRepository = bankClientRepository;
        this.mapBankInfosToDto = mapBankInfosToDto;
    }


    @Override
    public boolean validateCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName) {
        log.info("validating card data");
        return bankCardRepository
                .existsBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(cardNumber,
                        cardCCV, bankClientEntity_fullName);
    }

    @Override
    public BankingInfosDto getBankClientFromCardInfos(String cardNumber, int cardCCV,
                                                      String bankClientEntity_fullName) {
        log.info("getting user data");
        BankClientEntity bankClientEntity = bankCardRepository
                .findBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(cardNumber,
                        cardCCV, bankClientEntity_fullName).getBankAccountEntity().getBankClientEntity();
        BankCardEntity transactionBankCardEntity = bankCardRepository
                .findBankCardEntityByCardNumberAndCardCCV(cardNumber, cardCCV);
        BankingInfosDto bankingInfosDto = mapBankInfosToDto.BankClientToDto(BankingInfosDto.class, bankClientEntity);
        bankingInfosDto.setTransactionBankCardEntity(transactionBankCardEntity);
        bankingInfosDto.setTransactionBankAccountEntity(transactionBankCardEntity.getBankAccountEntity());

        System.out.println(bankClientEntity);

        return bankingInfosDto;
    }


}
