package com.example.OnlineEventBooking.Controller;
import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    VenueService venueService;

    @PostMapping("/save")
    private String saveVenue(@RequestBody Venue venue){
        return venueService.saveVenue(venue);
    }

    @PutMapping("/update")
    private String updateVenue(@RequestBody Venue venue){
        return venueService.saveVenue(venue);
    }
}
