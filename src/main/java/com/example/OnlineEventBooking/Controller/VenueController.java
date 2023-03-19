package com.example.OnlineEventBooking.Controller;
import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    VenueService venueService;

    @PostMapping("/save")
    private VenueModel saveVenue(@RequestBody VenueModel venueModel){
        return venueService.saveVenue(venueModel);
    }
    @GetMapping("/get")
    private List<VenueModel> getVenue(@RequestParam(name = "venueId",required = false) String venueId){
        return venueService.getVenue(venueId);
    }

}
