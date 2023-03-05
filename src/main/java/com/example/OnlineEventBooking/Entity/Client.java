package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Client")
public class Client {
    @Id @Column(name = "client_id") private int clientId;
    @OneToMany @JoinColumn(name = "booking_id") List<Booking> bookings;
    @EmbeddedId
    PersonInfo personInfo;
}
