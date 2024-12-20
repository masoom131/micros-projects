package com.mgps.hotel.service.impl;

import com.mgps.hotel.exception.ResourceNotFoundException;
import com.mgps.hotel.model.Hotel;
import com.mgps.hotel.repository.HotelRepository;
import com.mgps.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        hotel.setHid(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hid) {
        return hotelRepository.findById(hid)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found!."));
    }
}
