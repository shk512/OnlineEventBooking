package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(date!=null){
           eventBookingModelList=bookingRepository.findAll().stream().map(EventBooking->new EventBookingModel()).filter(EventBookingModel->EventBookingModel.getId().equals(clientId)).collect(Collectors.toList());
        }else{
           eventBookingModelList=bookingRepository.findAll().stream().map(EventBooking->new EventBookingModel()).collect(Collectors.toList());
        }

        return eventBookingModelList;
    }

}
