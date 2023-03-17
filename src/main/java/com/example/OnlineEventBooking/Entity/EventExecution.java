package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EventExecution")
public class EventExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_execution_id")
    private int eventExecutionId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    EventBooking eventBooking;

    @Column(name = "attendee")
    private int attendee;

    @Column(name = "totalAmount")
    private long totalAmount;

    @Column (name = "concessionAmount")
    private long concessionAmount;
}
