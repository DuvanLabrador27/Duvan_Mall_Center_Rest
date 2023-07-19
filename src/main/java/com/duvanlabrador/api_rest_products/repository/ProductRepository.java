package com.duvanlabrador.api_rest_products.repository;

import com.duvanlabrador.api_rest_products.dto.ProductDTO;
import com.duvanlabrador.api_rest_products.entities.ProductEntity;
import com.duvanlabrador.api_rest_products.util.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    public ProductEntity findByReferenceId(String referenceId);
    public List<ProductEntity> findProductEntityByProductCategory(ProductCategory productCategory);
    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity p SET p.productStatus = true WHERE p.referenceId = :referenceId")
    public void enableProduct(@Param("referenceId") String referenceId);

    @Transactional
    @Modifying
    @Query("UPDATE ProductEntity p SET p.productStatus = false WHERE p.referenceId = :referenceId")
    public void disableProduct(@Param("referenceId") String referenceId);
}
