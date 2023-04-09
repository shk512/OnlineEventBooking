package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Model.PaymentModel;
import com.example.OnlineEventBooking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    EventBookingService eventBookingService;
    public PaymentModel savePayment(PaymentModel paymentModel){
        return new PaymentModel(paymentRepository.save(paymentModel.dissamble(eventBookingService.getBookingById(paymentModel.getEventBookingModel().getId()))));
    }
    public List<PaymentModel> getPayments(Long bookingId){
        if(eventBookingService.getBookingById(bookingId)!=null){
            return paymentRepository.findAll().stream().map(PaymentModel::new).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }
}
