package com.example.OnlineEventBooking.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private EventBooking eventBooking;
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "amountReceived")
    private double amountReceived;
}
