package com.igc.customerservice.controller;

import com.igc.customerservice.entity.Orders;
import com.igc.customerservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/api")
public class OrdersController {

    @Autowired
    OrderRepo orderRepo;

    @PostMapping("/addOrders")
    public Orders addOrders(@RequestBody Orders orders) {
        return orderRepo.save(orders);
    }

    @GetMapping("/getorderbyid/{oid}")
    public Orders getorderbyid(@PathVariable ("oid") int oid) {
        return orderRepo.findById(oid).get();
    }

    @GetMapping("/findOrdersByCid/{custid}")
    public List<Orders> findOrdersByCid(@PathVariable ("custid") int custid) {
        return orderRepo.findOrdersByCid(custid);
    }
}
