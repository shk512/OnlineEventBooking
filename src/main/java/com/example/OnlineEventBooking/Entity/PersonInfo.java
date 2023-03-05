package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PersonInfo {
    @Column(name = "name") private String name;
    @Column(name = "contact") private String contact;
    @Column(name = "city") private String city;
    @Column(name = "street_address") private String streetAddress;
}
