package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventBookingService {

    @Autowired
    private EventBookingRepository bookingRepository;

    @Transactional
    public EventBookingModel saveOrUpdateBooking(EventBookingModel bookingModel){
        return bookingModel.assemble(bookingRepository.save(bookingModel.dissamble()));
    }

    @Transactional
    public List<EventBookingModel> getBookingByClient(String date,String clientId){
        List<EventBookingModel> eventBookingModelList=new ArrayList<>();
        List<EventBooking> eventBookingList=new ArrayList<>();
        if(date!=null){
           // eventBookingList=bookingRepository.findByClientIdAndDate(clientId,date);
        }else{
            //eventBookingList=bookingRepository.findByClientId(clientId);
        }
        for (EventBooking eventBooking:eventBookingList) {
            eventBookingModelList.add(new EventBookingModel().assemble(eventBooking));
        }
        return eventBookingModelList;
    }

}
