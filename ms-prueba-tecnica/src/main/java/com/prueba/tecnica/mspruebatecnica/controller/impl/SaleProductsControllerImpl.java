package com.prueba.tecnica.mspruebatecnica.controller.impl;

import com.prueba.tecnica.mspruebatecnica.controller.SaleProductsController;
import com.prueba.tecnica.mspruebatecnica.controller.request.SaleProductRequest;
import com.prueba.tecnica.mspruebatecnica.controller.response.GetOrderResponse;
import com.prueba.tecnica.mspruebatecnica.controller.response.SaleProductResponse;
import com.prueba.tecnica.mspruebatecnica.service.SaleProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleProductsControllerImpl implements SaleProductsController {

    private final SaleProductsService service;


    @Override
    @PostMapping(value = "/createSale")
    public SaleProductResponse createSale(@RequestBody SaleProductRequest request) {
        return service.createOrder(request);
    }

    @Override
    @GetMapping(value = "/getOrders")
    public List<GetOrderResponse> getOrders() {
        return service.getOrders();
    }

    @Override
    @GetMapping(value = "/getOrder/{idOrder}")
    public GetOrderResponse getOrdetById(@PathVariable(name = "idOrder") Integer idOrder){
        return service.getOrderById(idOrder);
    }
}
