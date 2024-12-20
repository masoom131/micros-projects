package com.mgps.rating.controller;

import com.mgps.rating.model.Rating;
import com.mgps.rating.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/add")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping("/{rid}")
    public ResponseEntity<Rating> getRating(@PathVariable String rid) {
        return ResponseEntity.ok(ratingService.getRating(rid));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String uid) {
        return ResponseEntity.ok(ratingService.getRatingByUserId(uid));
    }

    @GetMapping("/hotel/{hid}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hid) {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hid));
    }
}
