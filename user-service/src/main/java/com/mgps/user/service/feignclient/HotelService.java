package com.mgps.user.service.feignclient;

import com.mgps.user.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    //declarative method
    @GetMapping("/hotels/{hid}")
    Hotel getHotel(@PathVariable("hid") String hid);


}
