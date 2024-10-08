package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(updatedEmployee.getName());
            employee.setRole(updatedEmployee.getRole());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
