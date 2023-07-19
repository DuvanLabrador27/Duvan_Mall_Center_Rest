package com.duvanlabrador.api_rest_products.dto;

import com.duvanlabrador.api_rest_products.util.ProductCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long idCount;
    private String referenceId;
    private String productName;
    private LocalDate fabricationDate;
    private LocalDate expirationDate;
    private double productPrice;
    private Integer productStock;
    private ProductCategory productCategory;
    private Boolean productStatus;

}
