package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaID;
    private String name;
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Employee> employees;
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Theater> theaters;



}
