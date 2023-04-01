package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.ClientModel;
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
    @Autowired
    ClientService clientService;
    @Autowired
    VenueService venueService;
    @Transactional
    public EventBookingModel saveBooking(EventBookingModel bookingModel){
        EventBookingModel eventBookingModel;
        Client client=clientService.saveClient(bookingModel.getClientId()).dissamble();
        Venue venue=venueService.getVenueEntity(bookingModel.getVenueId().getId());
        if(bookingModel.getId()!=null){
            if(bookingRepository.existsById(bookingModel.getId()))
            {
                eventBookingModel=new EventBookingModel(bookingRepository.save(bookingModel.dissamble(client,venue)));
            }else {
                eventBookingModel=null;
            }

        }else{
            if(searchBooking(venue.getId(),bookingModel.getDate())){
                eventBookingModel=new EventBookingModel(bookingRepository.save(bookingModel.dissamble(client,venue)));
            }else {
                eventBookingModel=null;
            }
        }
        return  eventBookingModel;
    }
    @Transactional
    private Boolean searchBooking(Long venue, Date date){
        boolean result;
        if(bookingRepository.findEventBookingByVenue_IdAndDate(venue,date)!=null){
            result=false;
        }else{
            result=true;
        }
        return  result;
    }
    @Transactional
    public EventBooking getBookingById(Long id){
        return bookingRepository.findById(id).get();
    }
    @Transactional
    public List<EventBookingModel> getBookingByClientId(Long clientId){
        return bookingRepository.findEventBookingByClient_Id(clientId).stream().map(EventBookingModel::new).collect(Collectors.toList());
    }
    @Transactional
    public String deleteBooking(Long id){
        String response;
        if(getBookingById(id)!=null){
            bookingRepository.deleteById(id);
            response="Deleted Successfully";
        }else {
            response="Not Found";
        }
        return response;
    }

}
