package com.test.pca.services;

import com.test.pca.entities.BankClientEntity;

public interface CardDataValidation {
    boolean validateCardInfos(String bankClientEntity_fullName, String cardNumber, int cardCCV);
    BankClientEntity getBankClientFromCardInfos(String bankClientEntity_fullName, String cardNumber, int cardCCV);
}
