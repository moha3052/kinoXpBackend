package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8081") // Tillad adgang fra frontend-serveren
@RestController
@RequestMapping("/api/login")
public class EmployeeController {


    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // Login
    @PostMapping("/login")
    public Employee login(@RequestBody Map<String, String> credentials) {
        String name = credentials.get("name");
        String password = credentials.get("password");

        Optional<Employee> employeeOptional = employeeService.login(name);

        if (employeeOptional.isPresent() && employeeOptional.get().getPassword().equals(password)) {
            return employeeOptional.get(); // Login lykkedes
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Forkert navn eller adgangskode");
        }
    }





   /* @PostMapping
    public Employee login(@RequestParam String name, @RequestParam String password) {
        Employee employee = employeeService.login(name);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee; // Login successful
        } else {
            throw new RuntimeException("Forkert navn eller adgangskode");
        }
    }*/

}
