package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_execution")
public class EventExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_execution_id")
    private Long eventExecutionId;

    @Column(name = "attendee")
    private int attendee;

    @Column(name = "totalAmount")
    private long totalAmount;

    @Column (name = "concessionAmount")
    private long concessionAmount;
}
