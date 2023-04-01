package com.example.OnlineEventBooking.Controller;

import com.example.OnlineEventBooking.Model.PaymentModel;
import com.example.OnlineEventBooking.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("/save")
    private PaymentModel savePayment(@RequestBody PaymentModel paymentModel){
        return paymentService.savePayment(paymentModel);
    }
    @GetMapping("/")
    private List<PaymentModel> getPayment(@RequestParam(name = "id",required = false) Long id){
        return paymentService.getPayments(id);
    }
}
