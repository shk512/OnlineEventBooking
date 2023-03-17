package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class EventBookingModel {
    private long id;
    private String date;
    private String time;
    private int persons;
    private double totalAmount;
    private double advanceAmount;
    private double balanceAmount;
    private String menu;
    private String extraDetails;
    private String paymentMode;
    private boolean isBookingConfirm;
    private ClientModel clientId;
    private VenueModel venueId;

    public EventBooking dissamble(){
        EventBooking eventBooking=new EventBooking();

        eventBooking.setDate(this.date);
        eventBooking.setBookingConfirm(this.isBookingConfirm);
        eventBooking.setMenu(this.menu);
        eventBooking.setPaymentMode(this.paymentMode);
        eventBooking.setAdvanceAmount(this.advanceAmount);
        eventBooking.setBalanceAmount(this.balanceAmount);
        eventBooking.setTime(this.time);
        eventBooking.setPersons(this.persons);
        eventBooking.setTotalAmount(this.totalAmount);
        eventBooking.setExtraDetails(this.extraDetails);
        eventBooking.setClient(this.clientId.dissamble());
        eventBooking.setVenue(this.venueId.dissamble());

        return eventBooking;
    }

    public EventBookingModel assemble(EventBooking eventBooking){
        EventBookingModel eventBookingModel=new EventBookingModel();

        eventBookingModel.setId(eventBooking.getBookingId());
        eventBookingModel.setDate(eventBooking.getDate());
        eventBookingModel.setTime(eventBooking.getTime());
        eventBookingModel.setPersons(eventBooking.getPersons());
        eventBookingModel.setMenu(eventBooking.getMenu());
        eventBookingModel.setPaymentMode(eventBooking.getPaymentMode());
        eventBookingModel.setTotalAmount(eventBooking.getTotalAmount());
        eventBookingModel.setAdvanceAmount(eventBooking.getAdvanceAmount());
        eventBookingModel.setBalanceAmount(eventBooking.getBalanceAmount());
        eventBookingModel.setExtraDetails(eventBooking.getExtraDetails());
        eventBookingModel.setClientId(clientId.assemble(eventBooking.getClient()));
        eventBookingModel.setVenueId(venueId.assemble(eventBooking.getVenue()));
        if(eventBooking.isBookingConfirm()){
            eventBookingModel.setBookingConfirm(true);
        }else{
            eventBookingModel.setBookingConfirm(false);
        }


        return eventBookingModel;
    }
}