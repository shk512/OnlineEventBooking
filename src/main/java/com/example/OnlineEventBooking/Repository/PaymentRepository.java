package com.example.OnlineEventBooking.Repository;

import com.example.OnlineEventBooking.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findPaymentByEventBooking_Id(Long id);
}
