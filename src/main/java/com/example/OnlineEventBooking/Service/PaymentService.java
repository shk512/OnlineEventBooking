package com.example.OnlineEventBooking.Service;

import com.example.OnlineEventBooking.Model.PaymentModel;
import com.example.OnlineEventBooking.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    EventBookingService eventBookingService;
    public String savePayment(PaymentModel paymentModel){

        String result;
        if(eventBookingService.updateBooking(paymentModel.dissamble().getEventBooking())){
            new PaymentModel(paymentRepository.save(paymentModel.dissamble()));
            result="Transaction completed";
        }else {
            result="Error";
        }
        return result;
    }
    public List<PaymentModel> getPayments(Long bookingId){
        List<PaymentModel> paymentList;
        if(bookingId!=null){
            paymentList=paymentRepository.findPaymentByEventBooking_Id(bookingId).stream().map(PaymentModel::new).collect(Collectors.toList());
        }else{
            paymentList=paymentRepository.findAll().stream().map(PaymentModel::new).collect(Collectors.toList());
        }
        return paymentList;
    }
}
