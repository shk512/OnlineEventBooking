package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
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
    public String saveOrUpdateBooking(EventBooking booking){
        bookingRepository.save(booking);
        return "Success";
    }
  /*@Transactional
    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "Deleted";
    }*/

    @Transactional
    public List<EventBooking> getAllBookings(){
        List<EventBooking> bookingList=new ArrayList<EventBooking>();
        bookingRepository.findAll().forEach(booking->bookingList.add(booking));
        return bookingList;
    }

    /*@Transactional
    public Booking getBookingById(int id){
        return bookingRepository.findById(id).get();
    }*/

}
