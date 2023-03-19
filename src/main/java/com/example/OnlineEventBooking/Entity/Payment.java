package com.example.OnlineEventBooking.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private EventBooking eventBooking;

    @Column(name = "date")
    private String date;

    @Column(name = "payment_mode")
    private String paymentMode;

    @Column(name = "amountReceived")
    private double amountReceived;
}
