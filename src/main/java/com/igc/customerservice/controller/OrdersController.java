package com.igc.customerservice.controller;

import com.igc.customerservice.entity.Orders;
import com.igc.customerservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/api")
public class OrdersController {

    @Autowired
    OrderRepo orderRepo;

    @PostMapping("/addOrders")
    public Orders addOrders(@RequestBody Orders orders) {
        return orderRepo.save(orders);
    }
}
