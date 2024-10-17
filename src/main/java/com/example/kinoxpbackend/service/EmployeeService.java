package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee login(String name) {
        return employeeRepository.findByName(name); // Denne metode skal være korrekt implementeret i dit repository
    }
}
