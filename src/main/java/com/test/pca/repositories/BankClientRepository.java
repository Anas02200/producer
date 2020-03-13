package com.test.pca.repositories;

import com.test.pca.entities.BankClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//@RepositoryRestResource
public interface BankClientRepository extends JpaRepository<BankClientEntity, String>{

}
