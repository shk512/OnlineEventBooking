package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.EventExecution;
import com.example.OnlineEventBooking.Model.EventExecutionModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import com.example.OnlineEventBooking.Repository.EventExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventExecutionService {
    @Autowired
    EventExecutionRepository eventExecutionRepository;
    @Autowired
    EventBookingService eventBookingService;
    @Autowired
    EventBookingRepository eventBookingRepository;
    public String executeEvent(EventExecutionModel eventExecutionModel)throws ParseException {
        //Today Date
        Date date = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate= dateFormat.format(date);
        Date checkDate=dateFormat.parse(formattedDate);

        //Event Date
        EventBooking event=eventBookingService.getBookingById(eventExecutionModel.getBookingId().getId());
        Date eventDate=event.getDate();
        String formDate=dateFormat.format(eventDate);
        Date compareDate=dateFormat.parse(formDate);
        //Response
        String response;
        if(compareDate.equals(checkDate)){
            if(eventExecutionRepository.findEventExecutionByEventBooking_Id(eventExecutionModel.getBookingId().getId())!=null){
                response="Oops! Already Executed";
            }else{
                EventBooking eventBooking=eventBookingService.getBookingById(eventExecutionModel.getBookingId().getId());
                EventExecution eventExecution=eventExecutionRepository.save(eventExecutionModel.dissamble(eventBooking));
                eventBooking.setIsExecuted(true);
                eventBookingRepository.save(eventBooking);
                response="Your balance is Rs."+eventExecution.getBalanceAmount()+"\nSuccessfully Executed. See you again!";
            }
        }else{
            response="Event is not ready to execute today";
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
