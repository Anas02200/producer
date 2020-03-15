package com.test.pca.repositories;

import com.test.pca.entities.BankClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankClientRepository extends JpaRepository<BankClientEntity, String>{
    BankClientEntity findByFullName(String fullname);

}
