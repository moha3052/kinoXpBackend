package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByName(String name);
}




/*public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByName(String name); // Dette er forudsat at du bruger navnet til login
}*/
