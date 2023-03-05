package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Venue")
public class Venue {

    @Id @Column(name = "venue_id") private int venueId;
    @OneToMany List<Booking> bookings;
    @Embedded
    PersonInfo personInfo;
    @Column(name = "package_start_date") private String packageStartDate;
    @Column(name = "package_ends_date") private String packageEndsDate;
    @Column(name="is_package_active") private boolean isPackageActive;
}
