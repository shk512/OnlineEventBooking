package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class EventBookingModel {
    private Long id;
    private Date date;
    private String time;
    private int persons;
    private double advanceAmount;
    private double totalAmount;
    private double balanceAmount;
    private String menu;
    private String extraDetails;
    private String paymentMode;
    private Boolean isBookingConfirm;
    private ClientModel clientId;
    private VenueModel venueId;
    private EventExecutionModel eventExecutionModel;

    public EventBooking dissamble(){
        EventBooking eventBooking=new EventBooking();

        eventBooking.setDate(this.date);
        eventBooking.setIsBookingConfirm(this.isBookingConfirm);
        eventBooking.setMenu(this.menu);
        eventBooking.setPaymentMode(this.paymentMode);
        eventBooking.setAdvanceAmount(this.advanceAmount);
        eventBooking.setTime(this.time);
        eventBooking.setPersons(this.persons);
        eventBooking.setTotalAmount(venueId.getPerHeadRate()*this.persons);
        eventBooking.setBalanceAmount(eventBooking.getTotalAmount()-this.advanceAmount);
        eventBooking.setExtraDetails(this.extraDetails);
        eventBooking.setClient(clientId.dissamble());
        eventBooking.setVenue(venueId.dissamble());

        return eventBooking;
    }

    public EventBookingModel assemble(EventBooking eventBooking){
        EventBookingModel eventBookingModel=new EventBookingModel();

        eventBookingModel.setId(eventBooking.getId());
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
        eventBookingModel.setIsBookingConfirm(eventBooking.getIsBookingConfirm());


        return eventBookingModel;
    }
}