package com.prueba.tecnica.mspruebatecnica.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Builder
@Table(name = "ORDER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME_CUSTOMER")
    private String nameCustomer;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "DATE_SALE")
    private Date dateSale;

    @Column(name = "TICKET")
    private String ticket;

    @Column(name = "TOTAL")
    private BigDecimal total;

}
