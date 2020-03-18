package com.test.pca.repositories;

import com.test.pca.entities.BankCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankCardRepository extends JpaRepository<BankCardEntity, Long> {
    BankCardEntity findBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(
            String cardNumber, int cardCCV, String bankClientEntity_fullName);

    boolean existsBankCardEntityByCardNumberAndCardCCVAndBankAccountEntity_BankClientEntity_FullName(String cardNumber,
                                                                                                     int cardCCV,
                                                                                                     String bankClientEntity_fullName);

    BankCardEntity findBankCardEntityByCardNumberAndCardCCV(String cardNumber, int cardCCV);


}
