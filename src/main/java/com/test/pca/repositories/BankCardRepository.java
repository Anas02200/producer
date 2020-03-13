package com.test.pca.repositories;

import com.test.pca.entities.BankCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankCardRepository extends JpaRepository<BankCardEntity, Long> {


}
