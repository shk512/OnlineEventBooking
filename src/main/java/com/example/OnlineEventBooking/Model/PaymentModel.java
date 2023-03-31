package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class PaymentModel {
    private Long transactionId;
    private EventBookingModel eventBookingModel;
    private Date date;
    private String paymentMode;
    private double amountReceived;
    public PaymentModel(Payment payment){
        EventBookingModel eventBookingModel1=new EventBookingModel();
        this.setPaymentMode(payment.getPaymentMode());
        this.setDate(payment.getDate());
        this.setAmountReceived(payment.getAmountReceived());
        this.setEventBookingModel(eventBookingModel1.assemble(payment.getEventBooking()));
        this.setTransactionId(payment.getTransactionId());
    }
    public Payment dissamble(){
        Payment payment=new Payment();
        payment.setPaymentMode(this.paymentMode);
        payment.setTransactionId(this.transactionId);
        payment.setAmountReceived(this.amountReceived);
        payment.setEventBooking(eventBookingModel.dissamble());
        payment.setDate(new Date());
        return payment;
    }
}

