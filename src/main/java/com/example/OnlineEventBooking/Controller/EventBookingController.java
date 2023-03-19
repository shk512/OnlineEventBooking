package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class EventBookingController {

    @Autowired
    private EventBookingService bookingService;

    @PostMapping("/save")
    private String saveBooking(@RequestBody EventBookingModel bookingModel){
        EventBookingModel eventBookingModelResponse=bookingService.saveOrUpdateBooking(bookingModel);
        return "Your Booking has been successfully reserved. Your Booking Id is:"+eventBookingModelResponse.getId();
    }

    @GetMapping("/client/{clientId}/")
    private List<EventBookingModel> getBookings(@RequestParam(name = "date",required = false)String date,@PathVariable(name = "clientId")String clientId){
        return bookingService.getBookingByClient(date,clientId);
    }

}
