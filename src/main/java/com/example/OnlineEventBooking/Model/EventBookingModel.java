package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.*;
import jakarta.persistence.*;
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

    public EventBooking dissamble(){
        EventBooking eventBooking=new EventBooking();

        eventBooking.setDate(date);
        eventBooking.setBookingConfirm(isBookingConfirm);
        eventBooking.setMenu(menu);
        eventBooking.setPaymentMode(paymentMode);
        eventBooking.setAdvanceAmount(advanceAmount);
        eventBooking.setBalanceAmount(balanceAmount);
        eventBooking.setTime(time);
        eventBooking.setPersons(persons);
        eventBooking.setTotalAmount(totalAmount);
        eventBooking.setExtraDetails(extraDetails);

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
        if(eventBooking.isBookingConfirm()){
            eventBookingModel.isBookingConfirm=true;
        }else{
            eventBookingModel.isBookingConfirm=false;
        }


        return eventBookingModel;
    }
}