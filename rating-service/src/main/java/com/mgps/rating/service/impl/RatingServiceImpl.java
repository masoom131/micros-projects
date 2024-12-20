package com.mgps.rating.service.impl;

import com.mgps.rating.exception.ResourceNotFoundException;
import com.mgps.rating.model.Rating;
import com.mgps.rating.repository.RatingRepository;
import com.mgps.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(String rid) {
        return ratingRepository.findById(rid)
                .orElseThrow(()->new ResourceNotFoundException("Rating does not exists!."));
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String uid) {
        return ratingRepository.findByUid(uid);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hid) {
        return ratingRepository.findByHid(hid);
    }
}
