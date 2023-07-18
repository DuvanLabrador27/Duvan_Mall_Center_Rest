package com.duvanlabrador.api_rest_products.dto;

import com.duvanlabrador.api_rest_products.util.PaymentMethod;
import com.duvanlabrador.api_rest_products.util.StatusOrder;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long idOrder;
    private Integer orderQuantity;
    private StatusOrder statusOrder;
    private Double priceForProduct;
    private LocalDate dateOfTheOrder;
    private PaymentMethod paymentMethod;
}
