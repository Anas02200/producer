package com.test.pca.dataTransferObject;

import com.test.pca.entities.BankAccountEntity;
import com.test.pca.entities.BankCardEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankingInfosDto {
    private String fullName;
    private Calendar joinDate;
    private String identityCardNumber;
    private List<BankAccountEntity> bankAccounts;
    private List<BankCardEntity> bankCardEntities;
    private BankAccountEntity transactionBankAccountEntity;
    private BankCardEntity transactionBankCardEntity;
    private TransactionData transactionData;


}
