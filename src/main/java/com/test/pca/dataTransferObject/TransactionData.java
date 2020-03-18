package com.test.pca.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Currency;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionData {
    @JsonProperty("to")
    private String receiverName;
    @JsonProperty("to AccountNumber")
    private String receiverAccountNumber;
    @JsonProperty("transaction amount")
    private float transactionAmount;
    @JsonProperty("transaction currency")
    private Currency transactionCurrency;
    @JsonProperty("transaction time")
    private Date date;
    @JsonProperty("transaction country")
    private int transactionCountryCode;
    @JsonProperty("transaction process code")
    private String transactionProcessCode;
    @JsonProperty("transaction activity code")
    private int transactionActivityCode;
}
