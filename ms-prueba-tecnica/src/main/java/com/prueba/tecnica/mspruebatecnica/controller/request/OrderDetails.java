package com.prueba.tecnica.mspruebatecnica.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

    private String product;

    private String productCode;

    private BigDecimal price;

    private Integer quantity;

}
