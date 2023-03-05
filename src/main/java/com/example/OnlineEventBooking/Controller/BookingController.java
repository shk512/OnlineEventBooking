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
    BookingService bookingService;
}
