package com.test.pca.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.test.pca.entities.CardDataEntity;
import com.test.pca.entities.UserEntity;
@RepositoryRestResource
public interface CardsRepository extends JpaRepository<CardDataEntity, Long> {

	List<CardDataEntity> findByCardHolderId(@Param("cardHolderID") String cardHolderId, Sort sort);
}
