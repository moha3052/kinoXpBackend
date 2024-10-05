package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheaterRestController {
    @Autowired
    private TheaterService theaterService;


}
