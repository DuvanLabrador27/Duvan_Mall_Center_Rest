package com.duvanlabrador.api_rest_products.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_detail")
    private Long idProductDetail;
    @Column(name = "product_brand", nullable = false)
    private String productBrand;
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @ManyToOne(targetEntity = ProductEntity.class)
    @JoinColumn(name = "reference_Id")
    private ProductEntity productEntity;


}
