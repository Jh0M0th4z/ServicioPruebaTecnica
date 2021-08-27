package com.prueba.tecnica.mspruebatecnica.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Builder
@Table(name = "PRODUCT_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "ID_ORDER")
    private Integer idOrder;

    @Column(name = "PRODUCT_NAME")
    private String product;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Integer quantity;

}
