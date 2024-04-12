package com.rebel.Ecom.Butter_sb_API.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderUserName;
    private String orderFullAddress;
    private String orderContactNum;
    private String orderAlternativeContact;
    private String orderStatus;
    private Double orderAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user ;

    public OrderDetail(String orderUserName, String orderFullAddress, String orderContactNum, String orderAlternativeContact, String orderStatus, Double orderAmount, Product product, User user) {
        this.orderUserName = orderUserName;
        this.orderFullAddress = orderFullAddress;
        this.orderContactNum = orderContactNum;
        this.orderAlternativeContact = orderAlternativeContact;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }
}
