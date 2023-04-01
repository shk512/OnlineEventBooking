package com.example.OnlineEventBooking.Controller;

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
        return bookingService.saveBooking(bookingModel)!=null?"HURRAH! Congrats, Your booking has been reserved.":"Oops! Sorry, Your requested date is already reserved.";
    }
    @GetMapping("/client/{clientId}")
    private List<EventBookingModel> getBookings(@PathVariable(name = "clientId")Long clientId){
        return bookingService.getBookingByClientId(clientId);
    }
    @DeleteMapping("/delete{id}")
    private String deleteBooking(@PathVariable(name = "id")Long id){
        return bookingService.deleteBooking(id);
    }
}
