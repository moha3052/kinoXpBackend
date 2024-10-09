package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Customer;
import org.springframework.stereotype.Service;
import com.example.kinoxpbackend.repository.CustomerRepository;

import java.util.List;

@Service

public class CustomerService {

    final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getCustomerByPhoneNumber(int phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}

