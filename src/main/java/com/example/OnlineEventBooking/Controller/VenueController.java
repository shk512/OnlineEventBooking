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

    @PostMapping("/signup")
    private String saveVenue(@RequestBody VenueModel venueModel){
        return venueService.saveVenue(venueModel);
    }
    @GetMapping("/")
    private List<VenueModel> login(@RequestParam (name = "id",required = false)String id, @RequestParam(name = "pass",required = false)String pass){
        return venueService.getVenue(id,pass);
    }
    @PutMapping("/update")
    private String updateVenue(@RequestBody VenueModel venueModel){
        return venueService.update(venueModel);
    }
    @DeleteMapping("/delete/{id}")
    private String deleteVenue(@PathVariable(name = "id")String id){
        return venueService.deleteVenue(id);
    }
}
