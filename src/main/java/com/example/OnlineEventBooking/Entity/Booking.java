package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id @Column(name = "booking_id") private String bookingId;
    @ManyToOne @JoinColumn(name = "client_id") private Client client;
    @ManyToOne @JoinColumn (name = "venue_id") private Venue venue;
    @Column private String date;
    @Column private String time;
    @Column private String persons;
    @Column private double totalAmount;
    @Column private double advanceAmount;
    @Column private double balanceAmount;
    @Column private double concessionAmount;
    @Column private String menu;
    @Column private  String extraddetails;
    @Column private boolean isBookingConfirm;
}