package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class EmployeeRestController {


    final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Login
    @PostMapping
    public Employee login(@RequestParam String name, @RequestParam String password) {
        Employee employee = employeeService.login(name);
        if (employee != null) {
            return employee;
        } else {
            throw new RuntimeException("Forkert navn eller adgangskode");
        }
    }
}
