package com.test.pca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.pca.entities.UserEntity;
@RepositoryRestResource
public interface CardHoldersRepository extends JpaRepository<UserEntity, Long>{

}
