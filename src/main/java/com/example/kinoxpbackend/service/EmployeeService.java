package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Login-funktion uden Optional
    public Employee login(String name) {
        return employeeRepository.findByName(name);
    }
}
