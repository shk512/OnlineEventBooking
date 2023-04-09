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
    @PostMapping("/transaction")
    private PaymentModel savePayment(@RequestBody PaymentModel paymentModel){
        return paymentService.savePayment(paymentModel);
    }
    @GetMapping("/{id}")
    private List<PaymentModel> getPayment(@PathVariable(name = "id",required = false) Long id){
        return paymentService.getPayments(id);
    }
}
