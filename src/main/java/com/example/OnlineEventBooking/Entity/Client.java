package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="Client")
public class Client {
    @Id
    @Column(name = "client_id")
    private int clientId;

    @OneToMany
    @JoinColumn(name="booking_id")
    List<Booking> bookings;
    @Embedded
    private PersonInfo personInfo;
}
