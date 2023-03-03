package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Client")
public class Client {
    @Id @Column(name = "clientId") private Integer clientId;
    @Id @Column private String contact;
    @Column private String name;
    @OneToMany @JoinColumn(name = "bookingId") List<Booking> bookings;
}
