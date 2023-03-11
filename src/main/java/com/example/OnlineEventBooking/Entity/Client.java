package com.example.OnlineEventBooking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Client")
public class Client {
    @Id
    @Column(name = "client_id")
    private String clientId;

    @OneToMany
    List<EventBooking> bookings;
    @Embedded
    private PersonInfo personInfo;
}
