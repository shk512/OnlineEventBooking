package com.example.OnlineEventBooking.Service;


import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class VenueService {

    @Autowired
    VenueRepository venueRepository;

    public String saveVenue(Venue venue){
        venueRepository.save(venue);
        return "Success";
    }
}
