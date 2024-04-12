package com.rebel.Ecom.Butter_sb_API.Services;

import com.rebel.Ecom.Butter_sb_API.Models.OrderInput;
import com.rebel.Ecom.Butter_sb_API.Models.OrderProductQuantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService
{


    public void placeAnOrder(OrderInput orderInput);

}
