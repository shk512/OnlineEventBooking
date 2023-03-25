package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventBookingService {

  @Autowired
    EventBookingRepository bookingRepository;

    @Transactional
    public String saveOrUpdateBooking(EventBookingModel bookingModel){
        String result;
        EventBooking eventBooking=bookingModel.dissamble();
        if(searchBooking(eventBooking.getVenue().getId(),eventBooking.getDate())){
            bookingRepository.save(eventBooking);
            result="HURRAH! Congrats, Your booking has been reserved \n Your booking ID is:"+eventBooking.getId();
        }else {
            result="Oops! Sorry, Your requested date is already reserved.";
        }
        return  result;
    }
    @Transactional
    private Boolean searchBooking(String venue, Date date){
        boolean result;
        if(bookingRepository.findEventBookingByVenue_IdAndDate(venue,date)!=null){
            result=false;
        }else{
            result=true;
        }
        return  result;
    }

    @Transactional
    public List<EventBookingModel> getBookingByClientId(Date date,String clientId){
        List<EventBookingModel> venueList;
        if(date!=null){
            venueList=bookingRepository.findEventBookingByClient_IdAndDate(clientId, date).stream().map(EventBooking->new EventBookingModel()).collect(Collectors.toList());
        }else{
            venueList=bookingRepository.findEventBookingByClient_Id(clientId).stream().map(EventBooking->new EventBookingModel()).collect(Collectors.toList());
        }
        return venueList;
    }

}
