package com.example.OnlineEventBooking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Booking")
public class BookingModel {

    @Id @Column private String bookingId;
    @Column private String clientId;
    @Column private String venueId;
    @Column private String date;
    @Column private String time;
    @Column private String persons;
    @Column private double totalAmount;
    @Column private double advanceAmount;
    @Column private double balanceAmount;
    @Column private double concessionAmount;
    @Column private String menu;
    @Column private String isBookingConfirm;
}
