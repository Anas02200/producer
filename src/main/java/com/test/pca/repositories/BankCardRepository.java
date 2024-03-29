package com.test.pca.repositories;

import com.test.pca.entities.BankCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BankCardRepository extends JpaRepository<BankCardEntity, Long> {
   // List<BankCardEntity> findBankCardEntitiesByBankClientEntity_FullName(String bankClientEntity_fullName);
   // BankCardEntity findBankCardEntityByBankClientEntity_FullNameAndCardNumberAndCardCCV(String bankClientEntity_fullName, String cardNumber, int cardCCV);
   // boolean existsBankCardEntityByBankClientEntity_FullNameAndCardNumberAndCardCCV(String bankClientEntity_fullName, String cardNumber, int cardCCV);

    List<BankCardEntity> findBankCardEntitiesByBankAccountEntity_BankClientEntity_FullName(String bankClientEntity_fullName);
    BankCardEntity findBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(String cardNumber, int cardCCV,String bankClientEntity_fullName);
    boolean existsBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(String cardNumber, int cardCCV,String bankClientEntity_fullName);
}
