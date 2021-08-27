package com.prueba.tecnica.mspruebatecnica.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleProductRequest {

    private CustomerDetails customer;

    private List<OrderDetails> orders;

    private String dateSale;

    private String ticket;

    private BigDecimal total;

}
