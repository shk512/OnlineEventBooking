package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_execution")
public class EventExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private EventBooking bookingId;

    @Column(name = "attendee")
    private int attendee;

    @Column(name = "totalAmount")
    private long totalAmount;

    @Column (name = "concessionAmount")
    private long concessionAmount;
}
