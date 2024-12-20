package com.mgps.rating.service;

import com.mgps.rating.model.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating getRating(String rid);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserId(String uid);

    List<Rating> getRatingByHotelId(String hid);
}
