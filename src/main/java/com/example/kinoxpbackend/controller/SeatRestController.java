package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seat")
public class SeatRestController {

    final SeatService seatService;

    public SeatRestController(SeatService seatService){
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeat(){
        return seatService.getAllSeat();
    }
}
