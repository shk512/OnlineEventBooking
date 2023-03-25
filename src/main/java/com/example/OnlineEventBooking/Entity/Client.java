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
@Table(name="client")
public class Client {
    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "client")
    List<EventBooking> bookings;
    @Embedded
    private PersonInfo personInfo;
}
