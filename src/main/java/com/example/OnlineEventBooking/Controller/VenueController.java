package com.example.OnlineEventBooking.Controller;

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

    @PostMapping("/register")
    private VenueModel saveVenue(@RequestBody VenueModel venueModel){
        return venueService.saveVenue(venueModel);
    }
    @GetMapping("/")
    private List<VenueModel> getVenue(@RequestParam (name = "id",required = false)Long id){
        return venueService.getVenue(id);
    }
    @DeleteMapping("/delete/{id}")
    private String deleteVenue(@PathVariable(name = "id")Long id){
        return venueService.deleteVenue(id);
    }
}
