package com.igc.customerservice.controller;

import com.igc.customerservice.entity.Customer;
import com.igc.customerservice.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

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
}
