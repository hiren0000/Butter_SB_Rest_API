package com.rebel.Ecom.Butter_sb_API.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderInput
{
    private String fullName;
    private String fullAddress;
    private String contactNumber;
    private String alternativeContactNumber;

    private List<OrderProductQuantity> orderProductQuantityList;

}
