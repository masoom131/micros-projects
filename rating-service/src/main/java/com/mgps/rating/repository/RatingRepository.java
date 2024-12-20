package com.mgps.rating.repository;

import com.mgps.rating.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    /*custom finder method*/
    List<Rating> findByUid(String uid);

    List<Rating> findByHid(String hid);
}
