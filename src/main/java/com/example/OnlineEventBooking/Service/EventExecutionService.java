package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventExecutionModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import com.example.OnlineEventBooking.Repository.EventExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventExecutionService {
    @Autowired
    EventExecutionRepository eventExecutionRepository;
    @Autowired
    EventBookingService eventBookingService;
    public String executeEvent(EventExecutionModel eventExecutionModel){
        String response;
        if(eventExecutionRepository.findEventExecutionByEventBooking_Id(eventExecutionModel.getBookingId().getId())!=null){
            response="Oops! Already Executed";
        }else{
            eventExecutionRepository.save(eventExecutionModel.dissamble(eventBookingService.getBookingById(eventExecutionModel.getBookingId().getId())));
            response="Successfully Executed. See you again!";
        }
        return response;
    }
    public List<EventExecutionModel> getEvents(String venueId,Long bookingId){
        List<EventExecutionModel> list;
        if(bookingId!=null){
            list= eventExecutionRepository.findEventExecutionByEventBooking_IdAndEventBooking_Venue_Id(bookingId,venueId).stream().map(EventExecutionModel::new).collect(Collectors.toList());
        }else {
            list=eventExecutionRepository.findEventExecutionByEventBooking_Venue_Id(venueId).stream().map(EventExecutionModel::new).collect(Collectors.toList());
        }
        return list;
    }
}
