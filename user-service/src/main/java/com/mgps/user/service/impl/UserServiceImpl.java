package com.mgps.user.service.impl;

import com.mgps.user.exception.ResourceNotFoundException;
import com.mgps.user.model.Hotel;
import com.mgps.user.model.Rating;
import com.mgps.user.model.User;
import com.mgps.user.repository.UserRepository;
import com.mgps.user.service.UserService;
import com.mgps.user.service.feignclient.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(org.apache.catalina.User.class);

    @Override
    public User saveUser(User user) {
        user.setUid(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String uid) {

        //get user from db with the help of user repository by uid
        User user = userRepository.findById(uid).
                orElseThrow(()->new ResourceNotFoundException("User with given id is not found on the server!."));

        //fetch rating of the user from rating service, by using RestTemplate
        Rating[] ratingOfUser = restTemplate.getForObject("http://rating-service/ratings/user/"+user.getUid(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingOfUser).collect(Collectors.toList());

        List<Rating> hotels = ratings.stream().map(rating -> {
            //call hotel service api for hotel & set hotel ratings by using "feign client"
            rating.setHotel(hotelService.getHotel(rating.getHid()));
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;
    }





    /*@Override
    public User getUser(String uid) {

        //get user from db with the help of user repository by uid
        User user = userRepository.findById(uid).
                orElseThrow(()->new ResourceNotFoundException("User with given id is not found on the server!."));

        //fetch rating of the user from rating service, by using RestTemplate
        Rating[] ratingOfUser = restTemplate.getForObject("http://rating-service/ratings/user/"+user.getUid(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingOfUser).collect(Collectors.toList());

        List<Rating> hotels = ratings.stream().map(rating -> {

            //call hotel service api for hotel & set hotel ratings by using RestTemplate
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://hotel-service/hotels/"+rating.getHid(), Hotel.class);
            rating.setHotel(forEntity.getBody());
            logger.info("response status code: {}", forEntity.getStatusCode());

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratings);
        return user;
    }*/
}

