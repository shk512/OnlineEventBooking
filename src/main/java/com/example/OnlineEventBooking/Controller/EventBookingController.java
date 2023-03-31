package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class EventBookingController {

    @Autowired
    private EventBookingService bookingService;

    @PostMapping("/save")
    private String saveBooking(@RequestBody EventBookingModel bookingModel){
        String result;
        if(bookingService.saveBooking(bookingModel)){
            result="HURRAH! Congrats, Your booking has been reserved.";
        }else{
            result="Oops! Sorry, Your requested date is already reserved.";
        }
        return result;
    }

    @GetMapping("/client/{clientId}/")
    private List<EventBookingModel> getBookings(@RequestParam(name = "date",required = false) Date date, @PathVariable(name = "clientId")String clientId){
        return bookingService.getBookingByClientId(date,clientId);
    }

}
