package com.prueba.tecnica.mspruebatecnica.controller;

import com.prueba.tecnica.mspruebatecnica.controller.request.SaleProductRequest;
import com.prueba.tecnica.mspruebatecnica.controller.response.GetOrderResponse;
import com.prueba.tecnica.mspruebatecnica.controller.response.SaleProductResponse;

import java.util.List;

public interface SaleProductsController {

    SaleProductResponse createSale(SaleProductRequest request);

    List<GetOrderResponse> getOrders();

    GetOrderResponse getOrdetById(Integer idOrder);

}
