package com.rebel.Ecom.Butter_sb_API.Services.ServiceImpl;

import com.rebel.Ecom.Butter_sb_API.Models.*;
import com.rebel.Ecom.Butter_sb_API.Repo.OrderDetailRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.ProductRepo;
import com.rebel.Ecom.Butter_sb_API.Repo.UserRepo;
import com.rebel.Ecom.Butter_sb_API.Services.OrdersService;
import com.rebel.Ecom.Butter_sb_API.config.JwtAuthFilterr;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderDetailRepo orderRepo;

    private static final String ORDER_PLACED = "Placed";


    @Override
    public void placeAnOrder(OrderInput orderInput) {
        List<OrderProductQuantity> orderProductQuantityList = orderInput.getOrderProductQuantityList();

        for(OrderProductQuantity o: orderProductQuantityList)
        {

            Product product = this.productRepo.findById(o.getProductId()).get();

            String currentUser = JwtAuthFilterr.CURRENT_USER;

            User user = this.userRepo.findByEmail(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternativeContactNumber(),
                    ORDER_PLACED,
                    product.getActualPrice() * o.getQuantity(),
                    product,
                    user

            );

            this.orderRepo.save(orderDetail);
        }

    }
}
