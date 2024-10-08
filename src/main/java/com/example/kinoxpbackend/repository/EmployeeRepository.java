package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
