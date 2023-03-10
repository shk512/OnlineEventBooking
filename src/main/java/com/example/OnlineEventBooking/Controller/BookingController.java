package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Entity.Booking;
import com.example.OnlineEventBooking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    private String saveBooking(@RequestBody Booking booking){
        return bookingService.saveOrUpdateBooking(booking);
    }

    @PutMapping("/update")
    private String updateBooking(@RequestBody Booking booking){
        return bookingService.saveOrUpdateBooking(booking);
    }

    @DeleteMapping("delete/{id}")
    private String deleteBooking(@RequestParam("id") int id){
        return bookingService.deleteBooking(id);
    }

    @GetMapping("/getBookings")
    private List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/getBooking/{id}")
    private Booking getBookingById(@RequestParam("id") int id){
        return bookingService.getBookingById(id);
    }

}
