package com.prueba.tecnica.mspruebatecnica.service;

import com.prueba.tecnica.mspruebatecnica.controller.request.SaleProductRequest;
import com.prueba.tecnica.mspruebatecnica.controller.response.GetOrderResponse;
import com.prueba.tecnica.mspruebatecnica.controller.response.SaleProductResponse;

import java.util.List;

public interface SaleProductsService {

    SaleProductResponse createOrder(SaleProductRequest order);

    List<GetOrderResponse> getOrders();

    GetOrderResponse getOrderById(Integer idOrder);

}
