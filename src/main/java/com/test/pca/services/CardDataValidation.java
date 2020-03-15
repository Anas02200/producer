package com.test.pca.services;

import com.test.pca.entities.BankClientEntity;

public interface CardDataValidation {
    boolean validateCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName);

    BankClientEntity getBankClientFromCardInfos(String cardNumber, int cardCCV, String bankClientEntity_fullName);
}
