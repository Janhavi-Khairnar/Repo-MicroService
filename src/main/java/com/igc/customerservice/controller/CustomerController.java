package com.igc.customerservice.controller;

import com.igc.customerservice.entity.Customer;
import com.igc.customerservice.entity.Orders;
import com.igc.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepo.save(customer);
    }

    @GetMapping("/showCustomer")
    public List<Customer> showCustomer() {
        return customerRepo.findAll();
    }

    @GetMapping("getcustomerbyid/{cid}")
    public  Customer getcustomerbyid(@PathVariable ("cid") int cid) {
        return customerRepo.findById(cid).get();
    }

    @GetMapping("/getcustomerbycid/{cid}")
    public  Customer getcustomerbycid(@PathVariable ("cid") int cid) {
        Customer customer = customerRepo.findById(cid).get();

        //http://localhost:8002/orders/api/findOrdersByCid/2

        List<Orders> ordersList = restTemplate.getForObject("http://localhost:8002/orders/api/findOrdersByCid/"+cid, List.class);

        customer.setOrdersList(ordersList);

        return customer;

    }

}
