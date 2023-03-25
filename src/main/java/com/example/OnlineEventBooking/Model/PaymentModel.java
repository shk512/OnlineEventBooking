package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import jakarta.persistence.*;

import java.util.Date;

public class PaymentModel {
    private Long transactionId;
    private EventBooking eventBooking;
    private Date date;
    private String paymentMode;
    private double amountReceived;
}

