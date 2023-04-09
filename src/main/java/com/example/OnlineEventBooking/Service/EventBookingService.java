package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.Client;
import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.Venue;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Repository.EventBookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                if(!searchBooking(venue.getId(),bookingModel.getDate(),bookingModel.getTime())){
                    EventBooking eventBooking=bookingRepository.save(bookingModel.dissamble(client,venue));
                    if(eventBooking.getIsBookingConfirm()){
                        response="Booking confirmed successfully with boooking Id:"+eventBooking.getId();
                    }else {
                        response="Booking reserved successfully with boooking Id:"+eventBooking.getId();
                    }

                }else {
                    EventBooking getEvent =bookingRepository.findEventBookingByDateAndTimeAndVenue_Id(bookingModel.getDate(),bookingModel.getTime(),venue.getId());
                    if(!getEvent.getIsBookingConfirm()){
                        bookingModel.setId(getEvent.getId());
                        EventBooking eventBooking=bookingRepository.save(bookingModel.dissamble(client,venue));
                        response="Booking confirmed successfully with boooking Id:"+eventBooking.getId();
                    }else{
                        if(bookingModel.getTime().equalsIgnoreCase("morning")){
                            if(!searchBooking(venue.getId(),bookingModel.getDate(),"evening")){
                                response="Oops! Morning time reserved but Evening time available.";
                            }else{
                                response="Oops! Try another date.";
                            }
                        } else if (bookingModel.getTime().equalsIgnoreCase("evening")) {
                            if(!searchBooking(venue.getId(),bookingModel.getDate(),"morning")){
                                response="Oops! Evening time is reserved but Morning time is available.";
                            }else{
                                response="Oops! Try another date.";
                            }
                        } else{
                            response="Selected time is not available.";
                        }
                    }
                }
            }else{
                response="Couldn't save. Venue is inactive to book events right now.";
            }
        }
        return  response;
    }
    private Boolean searchBooking(Long venue, Date date,String time){
        boolean result;
        if(bookingRepository.findEventBookingByDateAndTimeAndVenue_Id(date,time,venue)!=null){
            result=true;
        }else{
            result=false;
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
        else {
           list=bookingRepository.findEventBookingByIdAndVenue_Id(bookingId,venueId).stream().map(EventBookingModel::new).collect(Collectors.toList());
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
