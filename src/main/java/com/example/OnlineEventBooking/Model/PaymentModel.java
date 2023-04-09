package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Entity.Payment;
import com.example.OnlineEventBooking.Service.EventBookingService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@NoArgsConstructor
public class PaymentModel {
    private Long transactionId;
    @JsonProperty("eventBooking")
    private EventBookingModel eventBookingModel;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String paymentMode;
    private double amountReceived;
    public PaymentModel(Payment payment){
        this.setPaymentMode(payment.getPaymentMode());
        this.setDate(payment.getDate());
        this.setAmountReceived(payment.getAmountReceived());
        this.setEventBookingModel(new EventBookingModel(payment.getEventBooking()));
        this.setTransactionId(payment.getTransactionId());
    }
    public Payment dissamble(EventBooking eventBooking){
        Payment payment=new Payment();
        payment.setPaymentMode(this.paymentMode);
        payment.setTransactionId(this.transactionId);
        payment.setAmountReceived(this.amountReceived);
        payment.setEventBooking(eventBooking);
        payment.setDate(new Date());
        return payment;
    }
}

