package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Venue")
public class Venue {

    @Id @Column(name = "venueId") private Integer venueId;
    @Id @Column private String contact;
    @Column private String venueName;
    @Column private String city;
    @Column private String streetAddress;
    @Column private String packageStartDate;
    @Column private String packageEndsDate;
    @Column private boolean isPackageActive;

    @OneToMany @JoinColumn(name = "bookingId") List<Booking> bookings;
}
