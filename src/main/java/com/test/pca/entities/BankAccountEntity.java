package com.test.pca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.pca.enums.AccountType;
import com.test.pca.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "Accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccountEntity implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private Long accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private Currencies accountCurrency ;
    private float accountBalance;
    @Column(name="ACCOUNT_IBAN")
    private Long accountIBAN;
    private String accountCreationBranch;
    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "AccountOwner", nullable = false)
    private BankClientEntity bankClientEntity;
    @OneToMany(mappedBy = "bankAccountEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankCardEntity> bankCardEntities;

    public BankAccountEntity(Long accountNumber, AccountType accountType, Currencies accountCurrency, float accountBalance, Long accountIBAN, String accountCreationBranch, BankClientEntity bankClientEntity) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountCurrency = accountCurrency;
        this.accountBalance = accountBalance;
        this.accountIBAN = accountIBAN;
        this.accountCreationBranch = accountCreationBranch;
        this.bankClientEntity = bankClientEntity;
    }
}
