package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterRestController {

    final TheaterService theaterService;

    public TheaterRestController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }
    @GetMapping
    public List<Theater> getTheaters(){
        return theaterService.getTheaters();
    }


    @PostMapping
    public Theater addTheater(@RequestBody Theater theater){
        return theaterService.createTheater(theater);
    }

    @DeleteMapping(("/{id}"))
    public void deleteTheaterService(@PathVariable int id){
        theaterService.deleteTheater(id);
    }







}
