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
@Transactional
public class EventBookingService{

    @Autowired
    private EventBookingRepository bookingRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private VenueService venueService;
    public String saveBooking(EventBookingModel bookingModel){
        String response;
        Client client=clientService.saveClient(bookingModel.getClientId()).dissamble();
        Venue venue=venueService.getVenueEntity(bookingModel.getVenueId().getId());
        if(bookingModel.getId()!=null){
            if(bookingRepository.existsById(bookingModel.getId()))
            {
                bookingRepository.save(bookingModel.dissamble(client,venue));
                response="Booking updated successfully";
            }else {
                response="Record not found against correspond Id";
            }

        }else{
            if(venue.getIsPackageActive()){
                if(searchBooking(venue.getId(),bookingModel.getDate(),bookingModel.getTime())){
                    EventBooking eventBooking=bookingRepository.save(bookingModel.dissamble(client,venue));
                    response="Booking Saved successfully with boooking Id:"+eventBooking.getId();
                }else {
                    if(bookingModel.getTime().equalsIgnoreCase("morning")){
                        if(searchBooking(venue.getId(),bookingModel.getDate(),"evening")){
                            response="Oops! Morning time reserved but Evening time available.";
                        }else{
                            response="Oops! Try another date.";
                        }
                    }else{
                        response="Oops! Already reserved. Try another date.";
                    }
                }
            }else{
                response="Couldn't save. Venue is inactive to book events";
            }
        }
        return  response;
    }
    private Boolean searchBooking(Long venue, Date date,String time){
        boolean result;
        if(bookingRepository.findEventBookingByVenue_IdAndDateAndTime(venue,date,time)!=null){
            result=false;
        }else{
            result=true;
        }
        return  result;
    }
    public EventBooking getBookingById(Long id){
        return bookingRepository.findById(id).get();
    }
    public List<EventBookingModel> getBookingForVenue(Long venueId,Long bookingId){
        List<EventBookingModel> list;
        if(venueId!=null&&bookingId==null){
            list=bookingRepository.findEventBookingByVenue_Id(venueId).stream().map(EventBookingModel::new).collect(Collectors.toList());
        }
        else if(bookingId!=null&&venueId==null){
           list=bookingRepository.findById(bookingId).stream().map(EventBookingModel::new).collect(Collectors.toList());
        }
        else {
            list=null;
        }
        return  list;
    }
    public List<EventBookingModel> getBookingForClient(String contact){
        return bookingRepository.findEventBookingByClient_PersonInfo_Contact(contact).stream().map(EventBookingModel::new).collect(Collectors.toList());
    }
    public String deleteBooking(Long id){
        String response;

        if(bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);
            response="Deleted Successfully";
        }else {
            response="Not Found";
        }
        return response;
    }

}
