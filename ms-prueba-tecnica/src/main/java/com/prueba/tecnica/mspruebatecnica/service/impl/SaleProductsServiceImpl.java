package com.prueba.tecnica.mspruebatecnica.service.impl;

import com.prueba.tecnica.mspruebatecnica.controller.request.CustomerDetails;
import com.prueba.tecnica.mspruebatecnica.controller.request.OrderDetails;
import com.prueba.tecnica.mspruebatecnica.controller.request.SaleProductRequest;
import com.prueba.tecnica.mspruebatecnica.controller.response.GetOrderResponse;
import com.prueba.tecnica.mspruebatecnica.controller.response.SaleProductResponse;
import com.prueba.tecnica.mspruebatecnica.repository.OrderDetailsRepo;
import com.prueba.tecnica.mspruebatecnica.repository.ProductDetailRepo;
import com.prueba.tecnica.mspruebatecnica.repository.entity.OrderDetail;
import com.prueba.tecnica.mspruebatecnica.repository.entity.ProductDetail;
import com.prueba.tecnica.mspruebatecnica.service.SaleProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleProductsServiceImpl implements SaleProductsService {

    private final OrderDetailsRepo orderDetailRepo;
    private final ProductDetailRepo productDetailRepo;

    @Override
    public SaleProductResponse createOrder(SaleProductRequest orders){

        try {
            OrderDetail orderDetail = OrderDetail.builder().nameCustomer(orders.getCustomer().getName())
                    .paymentMethod(orders.getCustomer().getPaymentMethod())
                    .dateSale(new SimpleDateFormat("dd/MM/yyyy").parse(orders.getDateSale()))
                    .ticket(orders.getTicket()).total(orders.getTotal()).build();

            orderDetailRepo.saveAndFlush(orderDetail);

            orders.getOrders().stream().forEach(order -> {
                ProductDetail productDetail = ProductDetail.builder().idOrder(orderDetail.getId())
                        .product(order.getProduct()).productCode(order.getProductCode())
                        .price(order.getPrice()).quantity(order.getQuantity()).build();
                productDetailRepo.saveAndFlush(productDetail);
            });

            return SaleProductResponse.builder().code(200).message("Registro exitoso").build();

        } catch (final ParseException pe) {
            return SaleProductResponse.builder().code(400).message("Ocurrió un error al registrar").build();
        }
    }

    @Override
    public List<GetOrderResponse> getOrders() {

        List<OrderDetail> orderDetails = orderDetailRepo.findAll();
        List<GetOrderResponse> productDetails = new ArrayList<>();

        orderDetails.stream().forEach(order -> {
            List<ProductDetail> productDetail = productDetailRepo.findByIdOrder(order.getId());

            CustomerDetails customer = CustomerDetails.builder().name(order.getNameCustomer()).paymentMethod(order.getPaymentMethod()).build();
            List<OrderDetails> orderDetailsList = new ArrayList<>();
            productDetail.stream().forEach(product -> {
                OrderDetails orderDet = OrderDetails.builder().product(product.getProduct()).productCode(product.getProductCode())
                        .price(product.getPrice()).quantity(product.getQuantity()).build();
                orderDetailsList.add(orderDet);
            });
            GetOrderResponse getOrderResponse = GetOrderResponse.builder().customer(customer).orders(orderDetailsList)
                    .dateSale(order.getDateSale().toString()).ticket(order.getTicket()).total(order.getTotal()).build();

            productDetails.add(getOrderResponse);
        });

        return productDetails;
    }

    @Override
    public GetOrderResponse getOrderById(Integer idOrder) {

        OrderDetail order = orderDetailRepo.findById(idOrder).orElse(null);

        if(order != null) {
            List<ProductDetail> productDetail = productDetailRepo.findByIdOrder(order.getId());

            CustomerDetails customer = CustomerDetails.builder().name(order.getNameCustomer()).paymentMethod(order.getPaymentMethod()).build();
            List<OrderDetails> orderDetailsList = new ArrayList<>();
            productDetail.stream().forEach(product -> {
                OrderDetails orderDet = OrderDetails.builder().product(product.getProduct()).productCode(product.getProductCode())
                        .price(product.getPrice()).quantity(product.getQuantity()).build();
                orderDetailsList.add(orderDet);
            });
            return GetOrderResponse.builder().customer(customer).orders(orderDetailsList)
                    .dateSale(order.getDateSale().toString()).ticket(order.getTicket()).total(order.getTotal()).build();
        } else {
            return null;
        }
    }

}
