package com.example.OnlineEventBooking.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class EventBooking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "eventBooking")
    private List<Payment> paymentModeList;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn (name = "venue_id")
    private Venue venue;
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private String time;
    @Column(name = "persons")
    private int persons;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "advance_amount")
    private double advanceAmount;
    @Column(name = "balance_amount")
    private double balanceAmount;
    @Column(name = "menu")
    private String menu;
    @Column(name = "extra_details")
    private String extraDetails;
    @Column(name = "is_booking_confirm")
    private Boolean isBookingConfirm;
    @Column(name = "is_executed")
    private Boolean isExecuted;
}
