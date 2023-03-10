package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Booking;
import com.example.OnlineEventBooking.Repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public String saveOrUpdateBooking(Booking booking){
        bookingRepository.save(booking);
        return "Success";
    }
    @Transactional
    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "Deleted";
    }

    @Transactional
    public List<Booking> getAllBookings(){
        List<Booking> bookingList=new ArrayList<Booking>();
        bookingRepository.findAll().forEach(booking->bookingList.add(booking));
        return bookingList;
    }

    @Transactional
    public Booking getBookingById(int id){
        return bookingRepository.findById(id).get();
    }

}
