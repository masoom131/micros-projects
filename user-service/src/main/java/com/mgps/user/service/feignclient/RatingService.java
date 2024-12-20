package com.mgps.user.service.feignclient;

import com.mgps.user.model.Rating;
import lombok.Builder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Service
@FeignClient(name = "rating-service")
public interface RatingService {

    @PostMapping("/ratings/add")
    public ResponseEntity<Rating> createRating(Rating rating);

    @PutMapping("/ratings/update/{rid}")
    public ResponseEntity<Rating> updateRating(@PathVariable String rid, Rating rating);

    @DeleteMapping("/ratings/delete/{rid}")
    public void deleteRating(@PathVariable String rid);

    @GetMapping("/ratings/user/{uid}")
    ResponseEntity<Rating> getRatingByUserId(@PathVariable String uid);
}
