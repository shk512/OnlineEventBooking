package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Model.EventExecutionModel;
import com.example.OnlineEventBooking.Service.EventExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/execution")
public class EventExecutionController {
    @Autowired
    EventExecutionService eventExecutionService;
    @PostMapping("/save")
    private String executeEvent(@RequestBody EventExecutionModel eventExecutionModel){
        return eventExecutionService.executeEvent(eventExecutionModel);
    }
    @GetMapping("/event/{venueId}")
    private List<EventExecutionModel> getEvents(@PathVariable(name = "venueId")String venueId,@RequestParam(name = "eventId",required = false)Long eventId){
        return eventExecutionService.getEvents(venueId,eventId);
    }
}
