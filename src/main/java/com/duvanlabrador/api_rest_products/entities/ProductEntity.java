package com.duvanlabrador.api_rest_products.entities;

import com.duvanlabrador.api_rest_products.util.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @Column(name = "reference_Id")
    private String referenceId;
    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;
    @Column(name = "fabrication_date", nullable = false, columnDefinition = "DATE")
    private LocalDate fabricationDate;
    @Column(name = "expiration_date", nullable = false, columnDefinition = "DATE")
    private LocalDate expirationDate;
    @Column(name = "product_price", nullable = false)
    private double productPrice;
    @Column(name = "product_stock")
    private Integer productStock;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private ProductCategory productCategory;
    @Column(name = "product_status", nullable = false)
    private Boolean productStatus;

    @OneToMany(targetEntity = ProductDetailEntity.class, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    private Set<ProductDetailEntity> productDetailEntities = new HashSet<>();

    @OneToMany(targetEntity = CommentsEntity.class, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    private Set<CommentsEntity> commentsEntities = new HashSet<>();

    @ManyToMany(targetEntity = OrderEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "product_order", joinColumns = @JoinColumn(name = "reference_Id"), inverseJoinColumns = @JoinColumn(name = "id_order"))
    private Set<OrderEntity> orderEntities = new HashSet<>();

}
