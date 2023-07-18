package com.duvanlabrador.api_rest_products.entities;

import com.duvanlabrador.api_rest_products.util.PaymentMethod;
import com.duvanlabrador.api_rest_products.util.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "order_of_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "order_quantity", nullable = false)
    private Integer orderQuantity;
    @Column(name = "status_order")
    private StatusOrder statusOrder;
    @Column(name = "price_for_product", nullable = false)
    private Double priceForProduct;
    @Column(name = "date_of_the_order", nullable = false)
    private LocalDate dateOfTheOrder;
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;


}
