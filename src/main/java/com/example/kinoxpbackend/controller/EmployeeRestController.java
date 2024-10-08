package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    // Login
    @PostMapping("/login")
    public Employee login(@RequestParam String name, @RequestParam String password) {
        Employee employee = employeeService.login(name);
        if (employee != null) {
            return employee;  // Returner medarbejderen, hvis login er succesfuld
        } else {
            throw new RuntimeException("Forkert navn eller adgangskode");
        }
    }
}
