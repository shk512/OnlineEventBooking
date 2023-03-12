package com.example.OnlineEventBooking.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Booking")
public class EventBooking {

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;

    @OneToMany
    private List<PaymentMode> paymentModeList;

    @OneToOne
    EventExecution eventExecution;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;
    @ManyToOne
    @JoinColumn (name = "venue_id")
    private Venue venueId;
    @Column(name = "date")
    private String date;
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
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "is_booking_confirm")
    private boolean isBookingConfirm;
}
