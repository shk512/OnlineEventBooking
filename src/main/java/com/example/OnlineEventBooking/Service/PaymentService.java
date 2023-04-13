package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Entity.EventBooking;
import com.example.OnlineEventBooking.Model.EventBookingModel;
import com.example.OnlineEventBooking.Model.PaymentModel;
import com.example.OnlineEventBooking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    EventBookingService eventBookingService;
    public PaymentModel savePayment(PaymentModel paymentModel) throws ParseException {
        EventBooking eventBooking=eventBookingService.getBookingById(paymentModel.getEventBookingModel().getId());
        PaymentModel paymentModel1;
        if(eventBooking!=null){
            paymentModel1= new PaymentModel(paymentRepository.save(paymentModel.dissamble(eventBooking)));
            eventBooking.setIsBookingConfirm(true);
            eventBookingService.saveBooking(new EventBookingModel(eventBooking));
        }else{
            paymentModel1=null;
        }
        return paymentModel1;
    }
    public List<PaymentModel> getPayments(Long bookingId){
        if(eventBookingService.getBookingById(bookingId)!=null){
            return paymentRepository.findAll().stream().map(PaymentModel::new).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }
}
