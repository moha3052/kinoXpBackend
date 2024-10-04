package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByPhoneNumber(int phoneNumber);
}
