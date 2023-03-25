package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventExecutionModel {
    private Long id;
    private Long bookingId;
    private int attendee;
    private long totalAmount;
    private long concessionAmount;
}
