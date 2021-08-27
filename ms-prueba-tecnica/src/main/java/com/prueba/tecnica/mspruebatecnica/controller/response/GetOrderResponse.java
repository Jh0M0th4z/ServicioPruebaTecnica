package com.prueba.tecnica.mspruebatecnica.controller.response;

import com.prueba.tecnica.mspruebatecnica.controller.request.CustomerDetails;
import com.prueba.tecnica.mspruebatecnica.controller.request.OrderDetails;
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
public class GetOrderResponse {

    private CustomerDetails customer;

    private List<OrderDetails> orders;

    private String dateSale;

    private String ticket;

    private BigDecimal total;

}
