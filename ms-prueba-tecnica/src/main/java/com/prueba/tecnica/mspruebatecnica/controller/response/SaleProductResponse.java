package com.prueba.tecnica.mspruebatecnica.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleProductResponse {

    private int code;
    private String message;

}
