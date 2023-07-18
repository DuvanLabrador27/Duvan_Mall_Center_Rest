package com.duvanlabrador.api_rest_products.repository;

import com.duvanlabrador.api_rest_products.entities.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity,Long> {

}
