package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
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

    public EventBookingModel(EventBooking eventBooking){
        this.setId(eventBooking.getId());
        this.setDate(eventBooking.getDate());
        this.setTime(eventBooking.getTime());
        this.setPersons(eventBooking.getPersons());
        this.setMenu(eventBooking.getMenu());
        this.setPaymentMode(eventBooking.getPaymentMode());
        this.setTotalAmount(eventBooking.getTotalAmount());
        this.setAdvanceAmount(eventBooking.getAdvanceAmount());
        this.setBalanceAmount(eventBooking.getBalanceAmount());
        this.setExtraDetails(eventBooking.getExtraDetails());
        this.setClientId(new ClientModel(eventBooking.getClient()));
        this.setVenueId(new VenueModel(eventBooking.getVenue()));
        this.setIsBookingConfirm(eventBooking.getIsBookingConfirm());
    }

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
}