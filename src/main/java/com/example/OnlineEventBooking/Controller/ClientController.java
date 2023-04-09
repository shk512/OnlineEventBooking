package com.example.OnlineEventBooking.Controller;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Model.VenueModel;
import com.example.OnlineEventBooking.Service.ClientService;
import com.example.OnlineEventBooking.Service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    EventBookingService eventBookingService;

    @GetMapping("/venue")
    private List<VenueModel> getVenueList(@RequestParam(name = "venueId",required = false)Long venueId){
        return clientService.getVenueList(venueId);
    }
    @PostMapping("/eventBooking")
    private String saveBooking(@RequestBody EventBookingModel eventBookingModel){
        try{
            return eventBookingService.saveBooking(eventBookingModel);
        }catch (Exception e){
            return e.toString();
        }
    }
    @GetMapping("/eventInfo/{contact}")
    private List<EventBookingModel> getEventsOfClient(@PathVariable(name = "contact")String contact){
        return eventBookingService.getBookingForClient(contact);
    }
}
