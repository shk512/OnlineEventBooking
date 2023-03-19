package com.example.OnlineEventBooking.Model;

import com.example.OnlineEventBooking.Entity.EventBooking;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventExecutionModel {
    private int id;

    private int attendee;

    @Column(name = "totalAmount")
    private long totalAmount;

    @Column (name = "concessionAmount")
    private long concessionAmount;
}
