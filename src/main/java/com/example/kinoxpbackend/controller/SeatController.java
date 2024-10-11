package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.service.SeatService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/seat")
public class SeatController {

    final SeatService seatService;

    public SeatController(SeatService seatService){
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeat(){
        return seatService.getAllSeat();
    }
}
