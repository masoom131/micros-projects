package com.mgps.hotel.controller;

import com.mgps.hotel.model.Hotel;
import com.mgps.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }

    @GetMapping("/{hid}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hid) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hid));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
}