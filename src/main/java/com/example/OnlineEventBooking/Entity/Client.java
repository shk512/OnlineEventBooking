package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Client")
public class Client {
    @Id @Column(name = "client_id") private int clientId;
    @Column private String contact;
    @Column private String name;
    @OneToMany @JoinColumn(name = "booking_id") List<Booking> bookings;
}
