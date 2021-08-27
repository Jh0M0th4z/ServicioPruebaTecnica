package com.prueba.tecnica.mspruebatecnica.repository;

import com.prueba.tecnica.mspruebatecnica.repository.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetail, Integer> {

}
