package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Venue")
public class Venue {

    @Id @Column(name = "venue_id")
    private int venueId;
    @OneToMany
    @JoinColumn(name="booking_id")
    List<Booking> bookings;
    @Embedded
    private PersonInfo personInfo;
    @Column(name = "package_start_date")
    private String packageStartDate;
    @Column(name = "package_ends_date")
    private String packageEndsDate;
    @Column(name="is_package_active")
    private boolean isPackageActive;
}
