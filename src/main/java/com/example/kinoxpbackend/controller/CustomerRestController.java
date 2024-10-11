package com.example.kinoxpbackend.controller;//*package controller;

import com.example.kinoxpbackend.model.Customer;
import org.springframework.web.bind.annotation.*;
import com.example.kinoxpbackend.service.CustomerService;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/api/customers")
public class    CustomerRestController {

    final CustomerService customerService;

    public CustomerRestController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/search")
    public List<Customer> getCustomerByPhoneNumber(@RequestParam int phoneNumber) {
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}

