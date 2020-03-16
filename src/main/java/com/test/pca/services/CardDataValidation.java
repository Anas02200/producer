package com.test.pca.services;

import com.test.pca.dataTransferObject.BankingInfosDto;

public interface CardDataValidation {
    boolean validateCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName);

    BankingInfosDto getBankClientFromCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName);
}
