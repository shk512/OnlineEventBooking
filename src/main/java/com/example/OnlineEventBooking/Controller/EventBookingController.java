package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class EventBookingController {

    @Autowired
    private EventBookingService bookingService;

    @PostMapping("/save")
    private long saveBooking(@RequestBody EventBookingModel bookingModel){
        EventBookingModel eventBookingModelResponse=bookingService.saveOrUpdateBooking(bookingModel);
        return eventBookingModelResponse.getId();
    }

}
