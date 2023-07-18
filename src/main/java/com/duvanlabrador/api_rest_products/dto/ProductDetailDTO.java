package com.duvanlabrador.api_rest_products.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Long idProductDetail;
    private String productBrand;
    private String productDescription;
}
