package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "event_execution")
public class EventExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "booking_id")
    private EventBooking eventBooking;
    @Column(name = "attendee")
    private int attendee;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "balance_amount")
    private double balanceAmount;
    @Column (name = "concession_amount")
    private double concessionAmount;
}
