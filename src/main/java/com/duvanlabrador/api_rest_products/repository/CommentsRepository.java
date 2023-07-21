package com.duvanlabrador.api_rest_products.repository;

import com.duvanlabrador.api_rest_products.entities.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity,Long> {

    public List<CommentsEntity> findByProductEntity_ReferenceId(String referenceId);
    public List<CommentsEntity> findByProductEntityIdCount(Long idCount);
}
