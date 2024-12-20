package com.mgps.hotel.service;

import com.mgps.hotel.model.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String hid);
}
