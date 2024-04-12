package com.rebel.Ecom.Butter_sb_API.Controller;

import com.rebel.Ecom.Butter_sb_API.Models.OrderInput;
import com.rebel.Ecom.Butter_sb_API.Services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrdersController
{
    @Autowired
    private OrdersService ordersService;


    @PostMapping("/placing-order")
    public void placeOrder(@RequestBody OrderInput orderInput)
    {
        this.ordersService.placeAnOrder(orderInput);
    }
}
