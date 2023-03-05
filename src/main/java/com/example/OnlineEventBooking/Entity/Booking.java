package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Booking")
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "booking_id") private int bookingId;
    @ManyToOne @JoinColumn(name = "client_id") private Client clientId;
    @ManyToOne @JoinColumn (name = "venue_id") private Venue venueId;
    @Column(name = "date") private String date;
    @Column(name = "time") private String time;
    @Column(name = "persons") private String persons;
    @Column(name = "total_amount") private double totalAmount;
    @Column(name = "advance_amount") private double advanceAmount;
    @Column(name = "balance_amount") private double balanceAmount;
    @Column(name = "concession_amount") private double concessionAmount;
    @Column(name = "menu") private String menu;
    @Column(name = "extra_details") private  String extraDetails;
    @Column(name = "is_booking_confirm") private boolean isBookingConfirm;
}
