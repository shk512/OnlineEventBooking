package com.example.OnlineEventBooking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venue")
public class VenueModel {
    @Id @Column private String mail;
    @Id @Column private String contact;
    @Column private String venueName;
    @Column private String city;
    @Column private String streetAddress;
}
