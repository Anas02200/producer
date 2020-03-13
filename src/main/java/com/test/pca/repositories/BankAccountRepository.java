package com.test.pca.repositories;


import com.test.pca.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository  extends JpaRepository<BankAccountEntity, Long> {

}
