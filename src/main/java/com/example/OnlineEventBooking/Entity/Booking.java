package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id @Column(name = "bookingId") private String bookingId;
    @ManyToOne @JoinColumn(name = "clientId") @Column private Client client;
    @ManyToOne @JoinColumn (name = "venueId") @Column private Venue venue;
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
