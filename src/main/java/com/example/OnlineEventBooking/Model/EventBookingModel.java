package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Data
@NoArgsConstructor
public class EventBookingModel {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String time;
    private int persons;
    private double advanceAmount;
    private double totalAmount;
    private double balanceAmount;
    private String menu;
    private String extraDetails;
    private Boolean isBookingConfirm;
    private Boolean isExecuted;
    @JsonProperty("client")
    private ClientModel clientId;
    @JsonProperty("venue")
    private VenueModel venueId;

    public EventBookingModel(EventBooking eventBooking){
        this.setId(eventBooking.getId());
        this.setDate(eventBooking.getDate());
        this.setTime(eventBooking.getTime());
        this.setPersons(eventBooking.getPersons());
        this.setMenu(eventBooking.getMenu());
        this.setTotalAmount(eventBooking.getTotalAmount());
        this.setAdvanceAmount(eventBooking.getAdvanceAmount());
        this.setBalanceAmount(eventBooking.getBalanceAmount());
        this.setExtraDetails(eventBooking.getExtraDetails());
        this.setClientId(new ClientModel(eventBooking.getClient()));
        this.setVenueId(new VenueModel(eventBooking.getVenue()));
        this.setIsBookingConfirm(eventBooking.getIsBookingConfirm());
        this.setIsExecuted(eventBooking.getIsExecuted());
    }

    public EventBooking dissamble(Client client,Venue venue){
        EventBooking eventBooking=new EventBooking();
        eventBooking.setId(this.id);
        eventBooking.setDate(this.date);
        eventBooking.setIsBookingConfirm(this.id!=null?this.isBookingConfirm:false);
        eventBooking.setIsExecuted(false);
        eventBooking.setMenu(this.menu);
        eventBooking.setAdvanceAmount(this.advanceAmount);
        eventBooking.setTime(this.time);
        eventBooking.setPersons(this.persons);
        eventBooking.setTotalAmount(venue.getPerHeadRate()*this.persons);
        eventBooking.setBalanceAmount(eventBooking.getTotalAmount()-this.advanceAmount);
        eventBooking.setExtraDetails(this.extraDetails);
        eventBooking.setClient(client);
        eventBooking.setVenue(venue);
        return eventBooking;
    }
}