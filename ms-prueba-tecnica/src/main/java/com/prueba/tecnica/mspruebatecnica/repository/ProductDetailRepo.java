package com.prueba.tecnica.mspruebatecnica.repository;

import com.prueba.tecnica.mspruebatecnica.repository.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDetailRepo extends JpaRepository<ProductDetail, Integer> {

    List<ProductDetail> findByIdOrder(Integer idOrder);
}
