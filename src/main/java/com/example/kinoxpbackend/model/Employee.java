package com.example.kinoxpbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int employeeID;
    private String name;
    private String role;

    public Employee(int employeeID,String name, String role){
        this.name = name;
        this.role = role;
        this.employeeID = employeeID;
    }

    public Employee() {

    }

    public int getEmployeeID(){
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    public String getName(){
        return getName();
    }

    public String getRole(){
        return getRole();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRole(String role){
        this.role = role;
    }

}
